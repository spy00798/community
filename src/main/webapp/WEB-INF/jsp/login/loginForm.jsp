<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-18
  Time: 오후 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/static/js/jquery/jquery-3.6.0.min.js"></script>
    <script src="/static/js/login/login.js"></script>
</head>
<body>
    <form id="loginForm">
        <fieldset>
            ID : <input type="text" id="userId"><br>
            PW : <input type="text" id="password">
            <input type="button" onclick="$.loginCheck()" value="LOGIN">
        </fieldset>
    </form>
</body>
</html>
