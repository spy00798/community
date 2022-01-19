<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-14
  Time: 오후 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../include/header.jsp" %>
    <fieldset id="view">
        <input type="hidden" id="idx" value="${board.id}">
        <p id="title-area"><span class="view-title">${board.title}</span><span class="view-date">${board.bdDate}</span>
        </p>
        <p style="vertical-align: top;">
        <pre id="view-area" style="width: 600px;">${board.content}</pre>
        </p>
        <div class="btn_area">
            <input type="button" value="수정하기" onclick="location.href = '/update?id=${board.id}'"/>
            <input type="button" value="목록" onclick="location.href= '/list';"/>
        </div>
    </fieldset>

<%@include file="../include/footer.jsp" %>
</div>
<script>
    document.title = `${board.title}`;
</script>
