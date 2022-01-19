package com.board.community.boardModule.service;

import com.board.community.common.db.jpa.entity.BoardEntity;
import com.board.community.common.db.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * FUNCTION:: DB에 저장된 게시글 목록 조회 후 JSP에 데이터 전달
     * @param model
     * @return
     */
    public String boardList(Model model) {
        model.addAttribute("boardList", boardRepository.findAll());
        return "/board/list";
    }

    /**
     * FUNCTION:: 게시글 등록 폼 JSP 페이지 반환
     * @return
     */
    public String boardInsertForm() {
        return "/board/insertForm";
    }

    /**
     * FUNCTION:: 게시글 등록 처리
     * @param boardEntity insertForm에서 입력한 데이터
     * @return
     */
    public String boardSave(BoardEntity boardEntity) {
        if(!boardEntity.getTitle().equals("") && !boardEntity.getContent().equals("")){
            boardEntity.setBdDate(new Date());
            boardRepository.save(boardEntity);

            return "success";
        } else {
            return "fail";
        }

    }

    /**
     * FUNCTION:: 게시글 상세보기 페이지
     * @param boardEntity 조회할 게시글 번호
     * @param model 조회 후 결과값 view.jsp에 출력
     * @return
     */
    public String boardView(BoardEntity boardEntity, Model model) {
        Optional<BoardEntity> viewData = boardRepository.findById(boardEntity.getId());
        model.addAttribute("board", viewData.get());

        return "/board/view";
    }

    /**
     * FUNCTION:: 게시글 수정페이지
     * @param model 수정하기 전 게시글 정보
     * @param boardEntity 수정하려는 게시글 번호
     * @return
     */
    public String boardUpdateForm(Model model, BoardEntity boardEntity) {
        Optional<BoardEntity> updateTarget = boardRepository.findById(boardEntity.getId());
        model.addAttribute("board", updateTarget.get());
        return "/board/updateForm";
    }

    /**
     * 게시글 수정 처리
     * @param boardEntity 수정할 게시글 번호, 수정 데이터
     * @return
     */
    public String boardModify(BoardEntity boardEntity) {
        if (!boardEntity.getTitle().equals("") && !boardEntity.getContent().equals("")) {
            Optional<BoardEntity> updateTarget = boardRepository.findById(boardEntity.getId());
            updateTarget.ifPresent(target -> {
                target.setId(boardEntity.getId());
                target.setTitle(boardEntity.getTitle());
                target.setContent(boardEntity.getContent());
                boardRepository.save(target);
            });
            return "success";
        } else {
            return "fail";
        }

    }

    /**
     * 게시글 삭제 처리
     * @param boardEntity 삭제하려는 게시글 번호
     * @return
     */
    public String boardDelete(BoardEntity boardEntity) {
        Optional<BoardEntity> deleteTarget = boardRepository.findById(boardEntity.getId());
        if (deleteTarget.isPresent()) {
            boardRepository.deleteById(boardEntity.getId());
            return "success";
        } else {
            return "fail";
        }
    }
}
