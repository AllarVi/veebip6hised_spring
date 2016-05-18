<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <c:if test="${not empty sessionScope.errors}">
        <div class="alert alert-danger">
            <strong>Viga!</strong> Salvestamine ebaõnnestus. Kontrolli, et kõik väljad oleksid täidetud.
        </div>
    </c:if>

    <c:url var="post_url"  value="/s?action=save" />
    <form:form action="${post_url}" modelAttribute="movie" method="post">

        <div class="form-group">
            <form:input path="id" type="text" id="id" class="form-control" readonly="true"></form:input>
            <form:errors path="id"></form:errors>
        </div>

        <div class="form-group">
            <form:input path="name" type="text" id="movieName" placeholder="Nimi" class="form-control"></form:input>
            <form:errors path="name"><p class="error">Nimi peab jääma 1 ja 30 tähemärgi vahele</p></form:errors>
        </div>

        <div class="form-group">
            <form:input path="genre" type="text" id="movieGenre" placeholder="Žanr" class="form-control"></form:input>
            <form:errors path="genre"><p class="error">Žanr peab jääma 1 ja 20 tähemärgi vahele</p></form:errors>
        </div>

        <div class="form-group">
            <form:input path="rating" type="number" id="movieRating" placeholder="Hinnang" class="form-control" min="0"></form:input>
            <form:errors path="rating"><p class="error">Hinnang peab jääma vahemikku 0-5</p></form:errors>
        </div>

        <div class="form-group">
            <form:textarea path="description" rows="3" id="movieDescription" placeholder="Kirjeldus" class="form-control"></form:textarea>
            <form:errors path="description"><p class="error">Kirjeldus ei tohi tühi olla</p></form:errors>
        </div>


        <button type="submit" class="btn btn-primary">Salvesta</button>
    </form:form>
</div>