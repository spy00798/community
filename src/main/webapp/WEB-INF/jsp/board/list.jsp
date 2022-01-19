<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-14
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/header.jsp"%>


    <ul>
        <c:forEach var="list" items="${boardList}">
            <a href="/view?id=${list.id}"><li>
                <span>${list.id}</span>
                <span>${list.title}</span>
                <span>${list.bdDate}</span>
            </li></a>
        </c:forEach>
    </ul>
    <button onclick="location.href = '/create';">등록</button>
</div>
<%@include file="../include/footer.jsp"%>
<script>
    document.title= "BoardList";
</script>
