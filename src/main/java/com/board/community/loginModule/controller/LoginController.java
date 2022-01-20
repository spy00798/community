package com.board.community.loginModule.controller;

import com.board.community.loginModule.service.LoginService;
import com.board.community.common.db.jpa.entity.LoginEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * FUNCTION:: 로그인 페이지
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return loginService.loginForm();
    }

    /**
     * FUNCTION:: 로그인 체크
     * @param loginEntity
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public String loginAjax(LoginEntity loginEntity, HttpServletRequest request) {
        return loginService.loginAjax(loginEntity, request);
    }

    /**
     * FUNCTION:: 회원가입 페이지
     * @return
     */
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String joinForm() {
        return loginService.joinForm();
    }

    /**
     * FUNCTION:: ID 중복체크
     * @param loginEntity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
    public String idDuplicateCheck(LoginEntity loginEntity) {
        return loginService.idDuplicateCheck(loginEntity);
    }

    @ResponseBody
    @RequestMapping(value = "/joinAction", method = RequestMethod.POST)
    public String joinAjax(LoginEntity loginEntity) {
        return loginService.joinAjax(loginEntity);
    }

    /**
     * FUNCTION:: 로그아웃 처리
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logoutAction(HttpSession session) {
        return loginService.logoutAction(session);
    }
}
