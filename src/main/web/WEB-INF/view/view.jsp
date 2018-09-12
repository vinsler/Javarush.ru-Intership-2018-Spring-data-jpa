<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>

<html>

<style type="text/css">
    .tab {margin-left: 30%}
</style>

<head>
    <title> view </title>
</head>

<body>


<h3 class="tab"> CURRENT PAGE -> ${page}</h3>
<h3 class="tab"> SIZE OF LIST -> ${detailList.size()}</h3>
<br>


<h1 class="tab"> View parts of details  </h1>

<c:if test="${!empty detailList}">
    <table class="tab">
        <tr>
            <th width="200">Name</th>
            <th width="80">Required</th>
            <th width="60">Counter</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${detailList}" var="detail">
            <tr>
                <td>${detail.name}</td>
                <td>${detail.required}</td>
                <td>${detail.count}</td>
                <td><a href="<c:url value='/edit/${detail.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/delete/${detail.id}/${page}/${detailList.size()}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<br>

    <c:if test="${page > 0}">
        <button class="tab" onclick= "location.href = '/view?page= + ${page - 1}'"> <<< </button>
    </c:if>
    <c:if test="${page == 0}">
        <button class="tab"> <<< </button>
    </c:if>

    &nbsp;&nbsp;&nbsp;&nbsp;

    <c:if test="${detailList.size() == 10 && size != detailList.size()}">
        <button onclick= "location.href = '/view?page= + ${page + 1}'"> >>> </button>
    </c:if>
    <c:if test="${detailList.size() <= 10}">
        <button> >>> </button>
    </c:if>


<br><br>
<h1 class="tab"> Add new detail </h1>
<br><br>

<form action="/add" class="tab" method="post">
    <input type="text" name="name" value="${name}" size="20" maxlength="10"> name
    <br><br>
    <input type="text" name="count" value="${count}" size="20" maxlength="100"> count
    <br><br>
    <input type="checkbox" name="required" size="20" maxlength="32"> required
    <br><br>
    <input type="submit" value="submit"/> &nbsp;
    <br><br>
</form>





</body>

</HTML>
