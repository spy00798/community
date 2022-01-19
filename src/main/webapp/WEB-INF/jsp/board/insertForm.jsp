<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-14
  Time: 오후 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/header.jsp"%>
    <form enctype="multipart/form-data" id="createForm">
        <fieldset id="view">
            <p>제목 : <input type="text" id="title"></p>
            <p style="vertical-align: top;">내용 : <br><textarea id="content" style="width: 500px; height: 300px; resize: none;"></textarea></p>
            <input type="button" value="등록하기" onclick="$.boardSave()"/>
        </fieldset>
    </form>
</div>
<%@include file="../include/footer.jsp"%>
<script>
    document.title = "CreateForm";
</script>
</html>
