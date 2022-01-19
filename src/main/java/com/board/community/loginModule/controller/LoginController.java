package com.board.community.loginModule.controller;

import com.board.community.loginModule.service.LoginService;
import com.board.community.common.db.jpa.entity.LoginEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return loginService.loginForm();
    }

    @ResponseBody
    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public String loginAjax(LoginEntity loginEntity, HttpServletRequest request) {
        return loginService.loginAjax(loginEntity, request);
    }
}
