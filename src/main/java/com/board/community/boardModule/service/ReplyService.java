package com.board.community.boardModule.service;

import com.board.community.common.db.jpa.entity.LoginEntity;
import com.board.community.common.db.jpa.entity.ReplyEntity;
import com.board.community.common.db.jpa.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    public String ReplyCreateAction(ReplyEntity replyEntity, HttpSession session) {
        LoginEntity loginSession = (LoginEntity) session.getAttribute("user");

        replyEntity.setWriter(loginSession.getUserName());
        replyEntity.setReDate(new Date());
        replyEntity.setUserId(loginSession.getUserId());

        replyRepository.save(replyEntity);

        return "success";
    }
}
