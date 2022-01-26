package com.board.community.boardModule.controller;

import com.board.community.boardModule.service.BoardService;
import com.board.community.common.db.jpa.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /**
     * FUNCTION:: 게시판 조회 페이지 url 매핑
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardList(@RequestParam(value = "option", required = false) String option, @RequestParam(value = "keyword", required = false) String keyword, Model model, HttpServletRequest request) {
        return boardService.BoardList(option, keyword, model, request);
    }

    /**
     * FINCTION::  게시글 등록 페이지                                                                                                                                                                          페이지 url매핑
     * @return
     */
    @RequestMapping(value = "/createForm" )
    public String boardCreateForm(HttpServletRequest request) {
        return boardService.BoardCreateForm(request);
    }

    /**
     * FUNCTION:: 게시글 등록 처리
     * @param boardEntity insertForm에서 입력한 데이터
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createAction", method = RequestMethod.POST)
    public String boardCreateAction(BoardEntity boardEntity, HttpSession session) {
        return boardService.BoardCreateAction(boardEntity, session);
    }

    /**
     * 게시글 상세보기 페이지
     * @param boardEntity 조회할 게시글 번호
     * @param model id에 해당하는 게시글의 데이터 출력
     * @return
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String boardView(BoardEntity boardEntity, Model model, HttpServletRequest request) {
        return boardService.BoardView(boardEntity, model, request);
    }

    /**
     * FUNCTION:: 게시글 수정 페이지
     * @param model 수정하기 전의 게시글 데이터
     * @param boardEntity 수정하려는 게시글의 idx 번호
     * @return
     */
    @RequestMapping(value = "/updateForm", method = RequestMethod.GET)
    public String boardUpdateForm(Model model, BoardEntity boardEntity, HttpServletRequest request) {
        return boardService.BoardUpdateForm(model, boardEntity, request);
    }

    /**
     * FUNCTION:: 게시글 수정 처리
     * @param boardEntity updateForm에 입력한 데이터 값
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateAction", method = RequestMethod.PUT)
    public String boardUpdateAction(BoardEntity boardEntity) {
        return boardService.BoardUpdateAction(boardEntity);
    }

    /**
     * FUNCTION:: 게시글 삭제 처리
     * @param boardEntity 삭제하려는 게시글 번호
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAction", method = RequestMethod.DELETE)
    public String boardDeleteAction(BoardEntity boardEntity) {
        return boardService.BoardDeleteAction(boardEntity);
    }




}
