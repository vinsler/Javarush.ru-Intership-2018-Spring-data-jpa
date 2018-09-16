<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>

<html>

<style type="text/css">
    A:link {
        font-size: 24px;
    }
    A:hover {
        font-size: 36px;
        font-weight: bold;
        color: black;
    }
</style>

<style type="text/css">
    .footer {
        border: 4px solid;
        border-color: darkslateblue;
        position: absolute;
        bottom: 5px;
        width: 98%;
        height: 100px;
        background: linen;
    }

    .header {
        border: 4px solid;
        border-color: darkslateblue;
        width: 98%;
        margin: 0 auto;
        padding: 10px;
        background: linen;
        height: 70px;
    }
</style>

<head>
    <title> PARTS </title>
</head>

<body>
<div class="header">
    <h1 align="center" style="color: darkslateblue">
        <em>
            Welcome to start page
        </em>
    </h1>
</div>
<br>
<h2 align="center">
    <em>
        Please press next.
    </em>
</h2>

<div role="main" align="center">
    <a href="/view?page=0"> Next </a>
</div>

<div class="footer">
    <h3 align="center" style="color: darkslateblue">
        <em>
            This is project for save & view parts <br>
            each one test task specially <br>
            for javarush intership.
        </em>
    </h3>
</div>

</body>

</html>