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

    <!-- Compressed CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/foundation/6.2.1/foundation.min.css">
</head>
<body>

<nav class="top-bar" data-topbar role="navigation">
    <ul class="title-area">
        <li class="name">
            <h1><a class="navbar-brand" href="${pageContext.request.contextPath}/s">Veebipõhised rakendused</a></h1>
        </li>
    </ul>

    <section class="top-bar-section">
        <!-- Right Nav Section -->
        <ul class="right">
            <li><a href="${pageContext.request.contextPath}/logs.txt" target="_blank">Logid</a></li>
            <li><a href="${pageContext.request.contextPath}/s">Servlet</a></li>
        </ul>

        <!-- Left Nav Section -->
        <ul class="left">
            <p class="navbar-text navbar-right">Allar Viinamäe 134302IAPB</p>
        </ul>
    </section>
</nav>

<div>

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

<!-- Compressed JavaScript -->
<script src="https://cdn.jsdelivr.net/foundation/6.2.1/foundation.min.js"></script>

</body>
</html>
