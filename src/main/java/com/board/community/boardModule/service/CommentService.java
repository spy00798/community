package com.board.community.boardModule.service;

import com.board.community.common.db.jpa.entity.BoardEntity;
import com.board.community.common.db.jpa.entity.CommentEntity;
import com.board.community.common.db.jpa.entity.LoginEntity;
import com.board.community.common.db.jpa.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    /**
     * FUNCTION:: 댓글 등록
     * @param commentEntity 댓글 정보
     * @param session 작성자 정보
     * @return
     */
    public String CommentCreateAction(CommentEntity commentEntity, HttpSession session) {
        LoginEntity loginEntity = (LoginEntity) session.getAttribute("user");


        commentEntity.setCommentDate(new Date());
        commentEntity.setWriter(loginEntity.getUserName());
        commentEntity.setUserId(loginEntity.getUserId());
//        commentEntity.setReplySequence(commentRepository.getByBoardIdxAndDepth(commentEntity.getBoardIdx(), 0) + 1);

        commentRepository.save(commentEntity);
        commentRepository.updateCommentGroup();

        return "success";
    }

    /**
     * FUNCTION:: 댓글 수정
     * @param commentEntity 댓글 수정란에 입력한 값
     * @return
     */
    public String CommentUpdateAction(CommentEntity commentEntity) {

        Optional<CommentEntity> updateTarget = commentRepository.findById(commentEntity.getIdx());
        updateTarget.ifPresent(item -> {

            commentEntity.setIdx(item.getIdx());
            commentEntity.setUserId(item.getUserId());
            commentEntity.setWriter(item.getWriter());
            commentEntity.setBoardIdx(item.getBoardIdx());
            commentEntity.setCommentDate(item.getCommentDate());


            commentRepository.save(commentEntity);
        });


        return "success";
    }

    /**
     * FUNCTION:: 댓글 삭제
     * @param commentEntity 삭제할 댓글의 번호
     * @return
     */
    public String CommentDeleteAction(CommentEntity commentEntity) {

        commentRepository.deleteById(commentEntity.getIdx());

        return "success";

    }

    public List<CommentEntity> CommentList(CommentEntity commentEntity) {

        return commentRepository.findAllByBoardIdx(commentEntity.getBoardIdx());
    }
}
