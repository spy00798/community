package com.board.community.loginModule.service;

import com.board.community.common.db.jpa.entity.LoginEntity;
import com.board.community.common.db.jpa.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public String loginForm() {
        return "/login/loginForm";
    }

    public String loginAjax(LoginEntity loginEntity, HttpServletRequest request) {
        Optional<LoginEntity> user = loginRepository.findByUserIdAndPassword(loginEntity.getUserId(), loginEntity.getPassword());

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user.get());
            return "success";
        } else {
            return "failed";
        }
    }

}
