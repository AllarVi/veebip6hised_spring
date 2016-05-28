<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coconuts</title>

    <style>
        .coconut-table th {
            text-align: center;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/s">Veebip6hised rakendused</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/../logs/lab1.log" target="_blank">Logid</a></li>
                <li><a href="${pageContext.request.contextPath}/s">Servlet</a></li>
            </ul>
            <p class="navbar-text navbar-right">Allar Viinamäe 134302IAPB</p>
        </div>
    </div>
</nav>

<div class="container">

    <div class="alert alert-danger text-center">
        <strong>Viga!</strong> Sellise id-ga kookost pole.
    </div>

</div>

</body>
</html>
