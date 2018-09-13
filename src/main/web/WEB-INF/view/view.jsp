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


<h4 class="tab"> CURRENT PAGE -> ${page}</h4>
<h4 class="tab"> NAME OF LISTS-> ${nameoflist}</h4>
<h4 class="tab"> SIZE OF LIST -> ${detailList.size()}</h4>
<h4 class="tab"> SIZE OF ALL LIST -> ${size}</h4>

<a class="tab" href="/required?page=0"> Required parts </a><br>
<a class="tab" href="/optional?page=0"> Optional parts </a><br>
<a class="tab" href="/view?page=0"> All exist parts </a><br>
<br>

<h1 class="tab"> View parts of details  </h1>

<c:if test="${!empty detailList}">
    <table class="tab">
        <tr>
            <th width="200">Name</th>
            <th width="80">Required</th>
            <th width="60">Count</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${detailList}" var="detail">
            <tr>
                <td>${detail.name}</td>
                <td>${detail.required}</td>
                <td>${detail.count}</td>
                <td><a href="<c:url value='/edit/${detail.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/delete/${detail.id}/${page}/${detailList.size()}/${nameoflist}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<br>

    <c:if test="${page > 0}">
        <button class="tab" onclick= "location.href = '/${nameoflist}?page=${page - 1}'"> <<< </button>
    </c:if>
    <c:if test="${page == 0}">
        <button class="tab"> <<< </button>
    </c:if>

    &nbsp;&nbsp;&nbsp;&nbsp;

    <c:if test="${detailList.size() + page * 10 < size}">
        <button onclick= "location.href = '/${nameoflist}?page=${page + 1}'"> >>> </button>
    </c:if>


<h3 class="tab"> Можно собрать ${minCount} компьютеров</h3>

<br><br>
<h1 class="tab"> Add new detail </h1>
<form action="/add" class="tab" method="post">
    <input type="text" name="name" value="${name}" size="20" maxlength="10"> name <br><br>
    <input type="text" name="count" value="${count}" size="20" maxlength="100"> count <br><br>
    <input type="checkbox" name="required" size="20" maxlength="32"> required <br><br>
    <input type="submit" value="submit"/>
</form>

<form action="/findByName/${name}" class="tab" method="get">
    <input type="text" name="name" size="40" maxlength="40"> name <br><br>
    <input type="submit" value="submit">
</form>


</body>

</HTML>
