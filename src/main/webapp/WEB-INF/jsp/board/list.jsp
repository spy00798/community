
<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-14
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/header.jsp"%>

<form action="/list" id="search-form">
<div id="search-area">
    <select name="option">
        <option value="all">전체</option>
        <option value="title">제목</option>
        <option value="writer">작성자</option>
    </select>
    <input type="text" name="keyword" id="keyword" value="${param.keyword}">
    <input type="submit" id="search-btn" value="검색">
</div>
</form>
    <ul id="dataList">
            <li>
                <span>번호</span>
                <span>작성자</span>
                <span>제목</span>
                <span>작성일</span>
            </li>
        <c:forEach var="list" items="${boardList}">
            <a href="/view?id=${list.id}">
                <li>
                <span>${list.id}</span>
                <span>${list.writer}</span>
                <span>${list.title}</span>
                <span>${list.bdDate}</span>
                </li>
            </a>
        </c:forEach>
    </ul>
    <c:if test="${sessionScope.user.userId != null}">
        <div class="ins">
            <button onclick="location.href = '/createForm';">등록</button>
        </div>
    </c:if>

</div>
<%@include file="../include/footer.jsp"%>
<script>
    document.title= "BoardList";
</script>
