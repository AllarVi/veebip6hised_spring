
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <title>Movies</title>

    <style>
        .movie-table th {
            text-align: center;
        }

        .form-container {
            display: none;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/s">Veebirakendused</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/log.txt" target="_blank">Logid</a></li>
                <li><a href="${pageContext.request.contextPath}/s">Servlet</a></li>
            </ul>
            <p class="navbar-text navbar-right">Rannar Allorg 134554IAPB</p>
        </div>
    </div>
</nav>

<div class="container-fluid">

    <c:choose>
        <c:when test="${movie != null}">
            <jsp:include page="movie_form.jsp" />
        </c:when>
        <c:otherwise>
            <jsp:include page="movie_table.jsp" />
        </c:otherwise>
    </c:choose>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<script>
    $(".description-link").click(function() {
        var movieId = $(this).attr('id').split("-")[1];

        $.get( "${pageContext.request.contextPath}/movieservice?id=" + movieId, function( data ) {
            showDescription(data);
        }).fail(function() {
            alert("Midagi läks valesti");
        });
    });

    $("#hide-desc").click(function() {
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
