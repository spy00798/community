package com.board.community.boardModule.service;

import com.board.community.common.db.jpa.entity.BoardEntity;
import com.board.community.common.db.jpa.entity.LoginEntity;
import com.board.community.common.db.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.DataException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
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
    public String boardList(String option, String keyword, Model model, HttpServletRequest request) {
        if (option != null && option.equals("title")) { //LINE:: 검색옵션을 제목으로 설정
            model.addAttribute("boardList", boardRepository.findByTitleContainingIgnoreCase(keyword));
        } else if (option != null && option.equals("writer")) { //LINE:: 검색옵션을 작성자로 설정
            model.addAttribute("boardList", boardRepository.findByWriterContainingIgnoreCase(keyword));
        } else if (option != null && option.equals("all")) { //LINE:: 검색옵션을 제목 or 작성자로 설정
            model.addAttribute("boardList", boardRepository.findByTitleContainingOrWriterContainingIgnoreCase(keyword, keyword));
        } else { //LINE:: 검색옵션을 설정 안 함 or 초기화면
            model.addAttribute("boardList", boardRepository.findAll());
        }
        return "/board/list";
    }

    /**
     * FUNCTION:: 게시글 등록 폼 JSP 페이지 반환
     * @return
     */
    public String boardCreateForm(HttpServletRequest request) {
        return "/board/createForm";
    }

    /**
     * FUNCTION:: 게시글 등록 처리
     * @param boardEntity insertForm에서 입력한 데이터
     * @return
     */
    public String boardCreateAction(BoardEntity boardEntity, HttpSession session) {
        LoginEntity member = (LoginEntity) session.getAttribute("user"); //LINE:: 로그인한 사용자의 세션을 가져옴
        try {
            boardEntity.setWriter(member.getUserName()); //LINE:: 가져온 세션에 존재하는 회원 데이터로 작성자 데이터 설정
            boardEntity.setUserId(member.getUserId()); //LINE:: 가져온 세션에 존재하는 회원 데이터로 작성자가 맞는지 구별하여 수정권한 부여
            boardEntity.setBdDate(new Date());
            boardRepository.save(boardEntity);
            return "success";
        } catch (EntityNotFoundException e) { //LINE:: 엔티티클래스를 찾을 수 없을 때 database error을 반환함
            return "database error";
        }

    }

    /**
     * FUNCTION:: 게시글 상세보기 페이지
     * @param boardEntity 조회할 게시글 번호
     * @param model 조회 후 결과값 view.jsp에 출력
     * @return
     */
    public String boardView(BoardEntity boardEntity, Model model, HttpServletRequest request) {
        Optional<BoardEntity> viewData = boardRepository.findById(boardEntity.getId()); //LINE:: Null값이 발생했을 때 처리를 하기위해 Optional객체 사용
        if (viewData.isPresent()) { //LINE:: 해당 번호의 게시글의 데이터가 존재할 때만 페이지에 출력
            model.addAttribute("board", viewData.get());
        }


        return "/board/view";
    }

    /**
     * FUNCTION:: 게시글 수정페이지
     * @param model 수정하기 전 게시글 정보
     * @param boardEntity 수정하려는 게시글 번호
     * @return
     */
    public String boardUpdateForm(Model model, BoardEntity boardEntity, HttpServletRequest request) {
        BoardEntity updateTarget = boardRepository.getById(boardEntity.getId()); //LINE:: 게시글의 수정 전 데이터를 가져옴.
        model.addAttribute("board", updateTarget);
        return "/board/updateForm";
    }

    /**
     * 게시글 수정 처리
     * @param boardEntity 수정할 게시글 번호, 수정 데이터
     * @return
     */
    public String boardUpdateAction(BoardEntity boardEntity) {
            Optional<BoardEntity> updateTarget = boardRepository.findById(boardEntity.getId());
            updateTarget.ifPresent(target -> {                  //LINE:: Optional 객체 내에 있는 값이 존재할 경우 함수 안의 로직을 실행
                target.setId(boardEntity.getId());
                target.setTitle(boardEntity.getTitle());
                target.setContent(boardEntity.getContent());
                boardRepository.save(target);                   //LINE:: ID에 해당하는 게시글 데이터가 이미 존재하므로 수정
            });
            return "success";

    }

    /**
     * 게시글 삭제 처리
     * @param boardEntity 삭제하려는 게시글 번호
     * @return
     */
    public String boardDeleteAction(BoardEntity boardEntity) {
            boardRepository.deleteById(boardEntity.getId());
            return "success";
    }

}
