<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-18
  Time: 오후 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/header.jsp" %>
<form>
    <fieldset class="user-form">
        <div>
        <div>ID :</div>
        <input type="text" id="userId" onchange="$.removeIdCheck()" idCheck="" onkeydown="$.spaceBar();"><input
            type="button" value="중복확인" onclick="$.idDuplicateCheck()"><br>
        <div>Password :</div>
        <input type="password" id="userPw" onkeydown="$.spaceBar();"><br>
        <div>Name :</div>
        <input type="text" id="userNm" onkeydown="$.spaceBar();"><br>
        <input type="button" value="JOIN" onclick="$.createUser()" class="btn_item">
        </div>
    </fieldset>
</form>

</body>
</html>
