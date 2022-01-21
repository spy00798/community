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
        <div id="title-area"><h3 class="view-title">${board.title}<br></h3><span id="writer">${board.writer}</span><span style="font-size: 20px;"> &middot; </span><span class="view-date">${board.bdDate}</span></div>
        <pre id="view-area" style="width: 600px;">${board.content}</pre>
        <div class="view">
            <c:if test="${sessionScope.user.userId == board.userId}">
                <input type="button" value="수정하기" onclick="location.href = '/updateForm?id=${board.id}'"/>
            </c:if>
            <input type="button" value="목록" onclick="location.href= '/list';"/>
        </div>
    </fieldset>

<%@include file="../include/footer.jsp" %>
</div>
<script>
    document.title = `${board.title}`;
</script>
