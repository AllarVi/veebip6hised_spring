<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coconuts</title>

    <style>
        .coconut-table th {
            text-align: center;
        }

        .error {
            color: pink;
        }

        .form-container {
            display: none;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/s">Veebipõhised rakendused</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/log.txt" target="_blank">Logid</a></li>
                <li><a href="${pageContext.request.contextPath}/s">Servlet</a></li>
            </ul>
            <p class="navbar-text navbar-right">Allar Viinamäe 134302IAPB</p>
        </div>
    </div>
</nav>

<div class="container-fluid">

    <c:choose>
        <c:when test="${coconut != null}">
            <jsp:include page="form_coconut.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="table_coconut.jsp"/>
        </c:otherwise>
    </c:choose>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script>
    $(".description-link").click(function () {
        var coconutId = $(this).attr('id').split("-")[1];

        $.get("${pageContext.request.contextPath}/coconutservice?id=" + coconutId, function (data) {
            showDescription(data);
        }).fail(function () {
            alert("Viga!");
        });
    });

    $("#hide-desc").click(function () {
        $(".form-container").hide();
    });

    function showDescription(data) {
        console.log(data.id);
        $("#id-value").text(data.id);
        $("#description").val(data.description);

        $(".form-container").show();
    }
</script>

</body>
</html>
