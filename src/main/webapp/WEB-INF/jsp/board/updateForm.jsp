<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-14
  Time: 오후 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/header.jsp"%>
    <form enctype="multipart/form-data" id="updateForm">
        <fieldset id="view">
            <input type="hidden" id="idx" value="${board.id}">
            <p class="title_input"><input type="text" id="title" value="${board.title}" /></p>
            <p id="content-area"><textarea id="content">${board.content}</textarea></p>
            <div class="btn_area view">
                <input type="button" value="수정" onclick="$.boardUpdate()"/>
                <input type="button" value="삭제" onclick="$.boardDelete()"/>
                <input type="button" value="뒤로" onclick="location.replace('/view?id=${board.id}')"/>
            </div>
        </fieldset>
    </form>
</div>
<%@include file="../include/footer.jsp"%>
<script>
    document.title = "Update : " + `${board.title}`;
</script>
</html>
