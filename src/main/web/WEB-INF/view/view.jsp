<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>

<style type="text/css">
    .tab {
        margin-left: 30%
    }
</style>

<style type="text/css">
    table {
        text-align: left;
        border-collapse: separate;
        border-spacing: 5px;
        background: #ECE9E0;
        color: #656665;
        border: 10px solid #ECE9E0;
        border-radius: 20px;
    }

    th {
        font-size: 12px;
        padding: 1px;
    }

    td {
        background: #F5D7BF;
        padding: 1px;
    }
</style>

<style>
    input[type=text] {
        padding: 5px;
        border: 2px solid #ccc;
        -webkit-border-radius: 5px;
        border-radius: 20px;
    }

    input[type=text]:focus {
        border-color: #333;
    }

    input[type=submit] {
        padding: 5px 15px;
        background: #ccc;
        border: 0 none;
        cursor: pointer;
        -webkit-border-radius: 5px;
        border-radius: 20px;
    }
</style>

<style type="text/css">
    button.new {
        background: -moz-linear-gradient(#D0ECF4, #5BC9E1, #D0ECF4);
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#D0ECF4), to(#D0ECF4), color-stop(0.5, #5BC9E1));
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00BBD6', endColorstr='#EBFFFF');
        padding: 3px 7px;
        color: #333;
        -moz-border-radius: 5px;
        -webkit-border-radius: 5px;
        border-radius: 15px;
        border: 1px solid #666;
    }
</style>

<head>
    <title> view </title>
</head>

<body>

<table class="tab">
    <tr>
        <td width="150" align="center"><a href="/required?page=0">Required</a></td>
        <td width="150" align="center"><a href="/optional?page=0">Optional</a></td>
        <td width="150" align="center"><a href="/view?page=0"> All </a></td>
    </tr>
</table>

<hr class="tab" width="40%">

<h3 class="tab"> View parts of details </h3>
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
                <td><a href="/edit?name=${detail.name}&page=${page}&size=${detailList.size()}&nameoflist=${nameoflist}">Edit</a>
                </td>
                <td>
                    <a href="<c:url value='/delete/${detail.id}/${page}/${detailList.size()}/${nameoflist}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<br>


<c:if test="${page > 0}">
    <a class="tab"> </a>
    <button class="new" onclick="location.href = '/${nameoflist}?page=${page - 1}'"> <<<<<</button>
</c:if>
<c:if test="${page == 0}">
    <a class="tab"> </a>
    <button class="new"> <<<<<</button>
</c:if>

&nbsp;&nbsp;&nbsp;&nbsp;

<c:if test="${detailList.size() + page * 10 < size}">
    <button class="new" onclick="location.href = '/${nameoflist}?page=${page + 1}'"> >>>>></button>
</c:if>


<hr class="tab" width="40%">

<form class="tab">
    <tr class="tab">
        <td> You can assemble</td>
        <td> ${minCount} </td>
        <td> computers</td>
    </tr>
</form>

<hr class="tab" width="40%">

<c:if test="${detailEdit.id == null}">
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
                <td><form:checkbox path="required"/></td>
            </tr>
            <tr>
                <td>Add detail</td>
                <td><input type="submit" value="Добавить"></td>
            </tr>
            </tbody>
        </table>
    </form:form>
</c:if>

<c:if test="${detailEdit.id != null}">
    <h3 class="tab"> Detail edit </h3>
    <form:form modelAttribute="detailEdit" action="/edit" method="put" class="tab">
        <form:input type="hidden" path="id" value="${detailEdit.id}"/>
        <table>
            <tbody>
            <tr>
                <td>Name</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Count</td>
                <td><form:input path="count"/></td>
            </tr>
            <tr>
                <td>Required</td>
                <td><form:checkbox path="required"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value=" Change "></td>
            </tr>
            </tbody>
        </table>
    </form:form>
</c:if>

<hr class="tab" width="40%">

<h3 class="tab"> Find detail </h3>
<form method="get" action="/find?=${name}" class="tab">
    <table>
        <td><input type="text" name="name" size="20" maxlength="40"> Name</td>
        <td><input type="submit" value=" Search "/></td>
    </table>
</form>

</body>

</HTML>
