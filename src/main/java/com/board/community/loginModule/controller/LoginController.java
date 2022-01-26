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
    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String loginForm() {
        return loginService.LoginForm();
    }

    /**
     * FUNCTION:: 로그인 체크
     * @param loginEntity 로그인 페이지에 입력한 데이터
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public String loginAction(LoginEntity loginEntity, HttpServletRequest request) {
        return loginService.LoginAction(loginEntity, request);
    }

    /**
     * FUNCTION:: 회원가입 페이지
     * @return
     */
    @RequestMapping(value = "/joinForm", method = RequestMethod.GET)
    public String joinForm() {
        return loginService.JoinForm();
    }

    /**
     * FUNCTION:: ID 중복체크
     * @param loginEntity 회원가입 페이지 내에 있는 ID입력칸에 입력한 데이터
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/idCheckAction", method = RequestMethod.POST)
    public String idDuplicateCheck(LoginEntity loginEntity) {
        return loginService.IdDuplicateCheck(loginEntity);
    }

    /**
     * 회원가입 처리
     * @param loginEntity 회원가입 페이지에 작성한 데이터
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/joinAction", method = RequestMethod.POST)
    public String joinAction(LoginEntity loginEntity) {
        return loginService.JoinAction(loginEntity);
    }

    /**
     * FUNCTION:: 로그아웃 처리
     * @param session
     * @return
     */
    @RequestMapping(value = "/logoutAction")
    public String logoutAction(HttpSession session) {
        return loginService.LogoutAction(session);
    }
}
