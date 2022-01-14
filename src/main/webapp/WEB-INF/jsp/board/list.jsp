<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KW
  Date: 2022-01-14
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
        <c:forEach var="list" items="${boardList}">
            <li>
                <span>${list.id}</span>
                <span>${list.title}</span>
                <span>${list.bdDate}</span>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
