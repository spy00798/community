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

    public String loginAction(LoginEntity loginEntity, HttpServletRequest request) {
        Optional<LoginEntity> idChk = loginRepository.findByUserId(loginEntity.getUserId());// id가 사용자 테이블에 등록되어 있는 아이디 인지 확인
        if (idChk.isPresent()) { //LINE:: Optional.isPresent() : Optional객체 내에 있는 데이터가 존재하는 지 확인
            Optional<LoginEntity> user = loginRepository.findByUserIdAndPassword(loginEntity.getUserId(), loginEntity.getPassword()); //LINE:: 아이디가 등록되어있으면 패스워드가 일치한지 확인
            if (user.isPresent()) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user.get()); //LINE:: 패스워드가 일치하다면 세션에 로그인한 사용자의 정보가 담긴 엔티티 객체 부여
                return "success";
            } else {
                return "failed"; //LINE:: 패스워드가 일치하지 않으면 failed 반환
            }
        } else {
            return "id not found"; //LINE:: 아이디가 등록되어있지 않다면 id not found 반환
        }

    }

    public String joinForm() {
        return "/login/joinForm";
    }

    public String idDuplicateCheck(LoginEntity loginEntity) {
        Optional<LoginEntity> checkTarget = loginRepository.findByUserId(loginEntity.getUserId()); //LINE:: 아이디 중복체크
        if(checkTarget.isPresent()) {
            return "duplicated"; //LINE:: 아이디가 이미 존재하면 duplicated 반환
        } else {
            return "available"; //LINE:: 존재하지 않다면 available 반환
        }
    }

    public String joinAction(LoginEntity loginEntity) {
            loginRepository.save(loginEntity); //LINE:: 회원가입 페이지에 입력한 데이터 저장
            return "success";
    }

    public String logoutAction(HttpSession session) {
        session.removeAttribute("user"); //LINE::로그아웃 시 key가 user인 데이터 제거
        return "redirect:/list"; //LINE:: 리스트페이지로 리다이렉트
    }



}
