package com.board.community.loginModule.service;

import com.board.community.common.db.jpa.entity.LoginEntity;
import com.board.community.common.db.jpa.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        Optional<LoginEntity> idChk = loginRepository.findByUserId(loginEntity.getUserId());

        if (idChk.isPresent()) {
            Optional<LoginEntity> user = loginRepository.findByUserIdAndPassword(loginEntity.getUserId(), loginEntity.getPassword());
            if (user.isPresent()) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user.get());
                return "success";
            } else {
                return "failed";
            }
        } else {
            return "id not found";
        }

    }

    public String joinForm() {
        return "/login/joinForm";
    }

    public String idDuplicateCheck(LoginEntity loginEntity) {
        Optional<LoginEntity> checkTarget = loginRepository.findByUserId(loginEntity.getUserId());
        if(checkTarget.isPresent()) {
            return "duplicated";
        } else {
            return "available";
        }
    }

    public String joinAjax(LoginEntity loginEntity) {
        if (!loginEntity.getUserId().isEmpty() && !loginEntity.getPassword().isEmpty() && !loginEntity.getUserName().isEmpty()) {
            loginRepository.save(loginEntity);
            return "success";
        } else {
            return "failed";
        }
    }

    public String logoutAction(HttpSession session) {
        session.removeAttribute("user");

        return "redirect:/list";
    }



}
