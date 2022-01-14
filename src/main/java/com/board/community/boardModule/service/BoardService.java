package com.board.community.boardModule.service;

import com.board.community.common.db.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;

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
}
