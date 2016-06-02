<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Documents</title>

    <style>
        .document-table th {
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
    </div>
</nav>

<div class="container">

    <div class="alert alert-danger text-center">
        <strong>Viga!</strong> Sellise id-ga dokuemnti pole.
    </div>

</div>

</body>
</html>
