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
            <p class="title_input"><input type="text" id="title" placeholder="제목"></p>
            <p id="content-area">
                <textarea id="content"></textarea>
            </p>
            <div class="view">
                <input type="button" value="등록하기" onclick="$.boardSave()"/>
                <input type="button" value="뒤로" onclick="history.back();"/>
            </div>
        </fieldset>
    </form>
</div>
<%@include file="../include/footer.jsp"%>
<script>
    document.title = "CreateForm";
</script>
</html>
