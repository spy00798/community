//package com.board.community.config.aop;
//
//import com.board.community.common.db.jpa.entity.LoginEntity;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@Aspect
//@Component
//public class LoginAOP {
//
//
//    @Around("execution(* com.board.community.boardModule.service.BoardService.*(..))")
//    public Object sessionCheck(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("--Login AOP--");
//
//        HttpServletRequest request = null;
//        for (Object o : pjp.getArgs()) {
//            if(o instanceof HttpServletRequest) {
//                request = (HttpServletRequest) o;
//            }
//        }
//
//        if (request != null){
//            String url = request.getRequestURL().toString();
//
//            if (url.endsWith("/create")) {
//                HttpSession session = request.getSession();
//
//                LoginEntity loginInfo = (LoginEntity) session.getAttribute("user");
//
//                if(loginInfo == null) {
//                    return "redirect:/login";
//                }
//            }
//        }
//
//        Object result = pjp.proceed();
//
//        return result;
//    }
//}
