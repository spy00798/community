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
        LoginEntity userInfo = (LoginEntity) session.getAttribute("user");


        commentEntity.setCommentDate(new Date());
        commentEntity.setWriter(userInfo.getUserName());
        commentEntity.setUserId(userInfo.getUserId());
        commentEntity.setReplySequence(commentRepository.countByBoardIdxAndDepth(commentEntity.getBoardIdx(), 0) + 1); //   댓글의 순서 설정
        commentEntity.setDepth(0);  //댓글의 depth설정

        commentRepository.save(commentEntity);
        commentRepository.updateCommentGroup(); // 등록 후 댓글의 소속을 자신의 idx로 변경

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

    /**
     * FUNCTION:: 댓글 리스트 출력
     * @param commentEntity 댓글의 부모 게시글 번호
     * @return
     */
    public List<CommentEntity> CommentList(CommentEntity commentEntity) {

        return commentRepository.findAllByBoardIdx(commentEntity.getBoardIdx());
    }

    public String ReplyCreateAction(CommentEntity commentEntity, HttpSession session) {
        CommentEntity parentComment = commentRepository.getById(Long.valueOf(commentEntity.getCommentGroup())); // 답글이 달리는 부모 댓글의 데이터를 가져옴
        LoginEntity userInfo = (LoginEntity) session.getAttribute("user");

        commentEntity.setCommentDate(new Date());
        commentEntity.setDepth(parentComment.getDepth() + 1);// 답글의 depth설정
        commentEntity.setReplySequence(commentRepository.countByBoardIdxAndDepthAndCommentGroup(parentComment.getBoardIdx(), (parentComment.getDepth() + 1), commentEntity.getCommentGroup()) + 1 ); // 답글의 순서
        commentEntity.setWriter(userInfo.getUserName());
        commentEntity.setUserId(userInfo.getUserId());
        commentRepository.save(commentEntity);

        return "success";
    }
}
