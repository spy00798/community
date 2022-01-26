package com.board.community.boardModule.controller;

import com.board.community.boardModule.service.CommentService;
import com.board.community.common.db.jpa.entity.CommentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * FUNCTION:: 댓글 등록기능
     * @param commentEntity 댓글 정보
     * @param session 작성자 정보
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/commentCreateAction")
    public String CommentCreateAction(CommentEntity commentEntity, HttpSession session) {
        return commentService.CommentCreateAction(commentEntity, session);
    }

    @ResponseBody
    @RequestMapping(value = "/commentUpdateAction")
    public String CommentUpdateAction(CommentEntity commentEntity) {
        return commentService.CommentUpdateAction(commentEntity);
    }

    @ResponseBody
    @RequestMapping(value = "/commentDeleteAction")
    public String CommentDeleteAction(CommentEntity commentEntity) {
        return commentService.CommentDeleteAction(commentEntity);
    }
}
