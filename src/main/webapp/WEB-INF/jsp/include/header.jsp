<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-14
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="/static/js/jquery/jquery-3.6.0.min.js"></script>
    <script src="/static/js/board/board.js?abc=123"></script>
    <script src="/static/js/login/login.js?abc=123"></script>
    <script src="/static/js/board/comment.js?abc=123"></script>
    <script src="/static/js/board/reply.js?abc=123"></script>
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="icon" href="/static/images/temp_icon.ico">
</head>
<body>
<header>
    <div>
        <h1>
            <a href="/list">notice board</a>
        </h1>
        <div>
            <c:choose>
                <c:when test="${sessionScope.user.userId == null && !fn:contains(pageContext.request.requestURL, '/login') && !fn:contains(pageContext.request.requestURL, '/join')}">
                    <input type="button" onclick="location.href = '/loginForm'" value="로그인">
                    <input type="button" onclick="location.href = '/joinForm'" value="회원가입">
                </c:when>
                <c:when test="${!fn:contains(pageContext.request.requestURL, '/login') && !fn:contains(pageContext.request.requestURL, '/join')}">
                    <input type="button" onclick="location.href = '/logoutAction'" value="로그아웃">
                </c:when>
            </c:choose>
        </div>
    </div>
</header>
<div id="wrap">