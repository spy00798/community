package com.board.community.boardModule.controller;

import com.board.community.boardModule.service.ReplyService;
import com.board.community.common.db.jpa.entity.ReplyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @ResponseBody
    @RequestMapping(value = "replyCreateAction")
    public String ReplyCreateAction(ReplyEntity replyEntity, HttpSession session) {

        return replyService.ReplyCreateAction(replyEntity, session);
    }
}
