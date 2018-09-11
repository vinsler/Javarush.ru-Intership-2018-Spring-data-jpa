<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>

<html>

<head>
    <title> view </title>
</head>

<body>

<p> VIEW VIEW  </p>



        <c:forEach items="${detailList}" var="detail">
            <tr>
                <td>${detail.id}</td>
                <td>${detail.name}</td>
                <td>${detail.required}</td>
                <td>${detail.count}</td>

                <td><a href="<c:url value='/edit/${detail.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${detail.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>



</body>
</html>