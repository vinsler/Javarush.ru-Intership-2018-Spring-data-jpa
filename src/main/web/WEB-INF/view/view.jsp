<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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


<c:if test="${detailForEdit != null}">
    <a> ${detailForEdit.name} </a>
</c:if>
<a> detailForEdit =  ${detailForEdit.name} </a>

<a class="tab"> NAME -> ${name}</a> <br>
<a class="tab"> CURRENT PAGE -> ${page}</a><br>
<a class="tab"> NAME OF LISTS-> ${nameoflist}</a><br>
<a class="tab"> SIZE OF LIST -> ${detailList.size()}</a><br>
<a class="tab"> SIZE OF ALL LIST -> ${size}</a><br><br>

<a class="tab" href="/required?page=0"> Required parts </a><br>
<a class="tab" href="/optional?page=0"> Optional parts </a><br>
<a class="tab" href="/view?page=0"> All exist parts </a>

<hr class="tab" width="40%">

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
                <td><a href="<c:url value='/edit/${detail.name}/${page}/${detailList.size()}/${nameoflist}'/>">Edit</a></td>
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

    <hr class="tab" width="40%">

    <form class="tab">
        <tr class="tab">
            <td> Можно собрать </td>
            <td> ${minCount} </td>
            <td> компьютеров </td>
        </tr>
    </form>

    <hr class="tab" width="40%">

    <h3 class="tab"> Add new detail </h3>
    <form:form modelAttribute="ctrlDetail" method="post" action="/add" class="tab">
        <table>
            <tbody>
            <tr>
                <td>Name</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>count</td>
                <td><form:input path="count"/></td>
            </tr>
            <tr>
                <td>Required</td>
                <td><form:checkbox  path="required"/></td>
            </tr>
            <tr>
                <td>Add detail </td>
                <td><input type="submit" value="Добавить"></td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <hr class="tab" width="40%">

    <h3 class="tab"> Find detail </h3>
    <form method="get" action="/find?=${name}" class="tab">
        <input type="text" name="name" size="20" maxlength="40"> NAME
        <input type="submit" value="submit"/>
    </form>

</body>

</HTML>
