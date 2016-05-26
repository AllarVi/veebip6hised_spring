<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <c:if test="${not empty sessionScope.errors}">
        <div class="alert alert-danger">
            <strong>Viga!</strong> Kontrolli, et kõik väljad oleksid täidetud.
        </div>
    </c:if>

    <c:url var="post_url" value="/s?action=save"/>
    <form:form action="${post_url}" modelAttribute="coconut" method="post">

        <div class="form-group">
            <form:input path="id" type="text" id="id" class="form-control" readonly="true"></form:input>
            <form:errors path="id"></form:errors>
        </div>

        <div class="form-group">
            <form:input path="name" type="text" id="coconutName" placeholder="Nimi" class="form-control"></form:input>
            <form:errors path="name"><p class="error">Nimi peab jääma 1 ja 30 tähemärgi vahele</p></form:errors>
        </div>

        <div class="form-group">
            <form:input path="weight" type="text" id="coconutWeight" placeholder="Kaal"
                        class="form-control"></form:input>
            <form:errors path="weight"><p class="error">Kaal peab jääma 1g ja 3000g vahele</p></form:errors>
        </div>

        <div class="form-group">
            <form:input path="rating" type="number" id="coconutRating" placeholder="Hinnang" class="form-control"
                        min="0"></form:input>
            <form:errors path="rating"><p class="error">Hinnang peab jääma vahemikku 0-5</p></form:errors>
        </div>

        <div class="form-group">
            <form:textarea path="description" rows="3" id="coconutDescription" placeholder="Kirjeldus"
                           class="form-control"></form:textarea>
            <form:errors path="description"><p class="error">Kirjeldus ei tohi tühi olla</p></form:errors>
        </div>


        <button type="submit" class="success button">Salvesta</button>
    </form:form>
</div>