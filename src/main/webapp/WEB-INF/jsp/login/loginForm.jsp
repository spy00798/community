<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-18
  Time: 오후 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/header.jsp" %>
<form id="loginForm">
    <fieldset class="user-form">
        <div>
            <input type="text" id="userId"placeholder="ID입력..."><br>
            <input type="password" id="userPw" placeholder="패스워드 입력...">
            <div>
                <input type="button" onclick="location.href = '/join'" value="JOIN" class="btn_item">
                <input type="button" onclick="$.loginCheck()" value="LOGIN" class="btn_item">
            </div>
        </div>
    </fieldset>
</form>
<%@include file="../include/footer.jsp" %>

