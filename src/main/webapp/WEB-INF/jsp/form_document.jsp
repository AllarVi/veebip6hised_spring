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
    <form:form action="${post_url}" modelAttribute="document" method="post">

        <div class="form-group">
            <form:input path="id" type="text" id="id" class="form-control" readonly="true"></form:input>
            <form:errors path="id"></form:errors>
        </div>

        <div class="form-group">
            <form:input path="name" type="text" id="documentName" placeholder="Nimi" class="form-control"></form:input>
            <form:errors path="name"><p class="error">Nimi peab jääma 1 ja 30 tähemärgi vahele</p></form:errors>
        </div>

        <div class="form-group">
            <form:input path="type" type="text" id="docType" placeholder="Tüüp" readonly="true"
                        class="form-control"></form:input>
        </div>

        <div class="form-group">
            <form:input path="filename" type="text" id="documentFilename" placeholder="Failinimi"
                        class="form-control"></form:input>
            <form:errors path="filename"><p class="error">Failinimi ei tohi olla tühi</p></form:errors>
        </div>

        <div class="form-group">
            <form:textarea path="description" rows="3" id="documentDescription" placeholder="Kirjeldus"
                           class="form-control"></form:textarea>
            <form:errors path="description"><p class="error">Kirjeldus ei tohi tühi olla</p></form:errors>
        </div>


        <button type="submit" class="success button">Salvesta</button>
    </form:form>
</div>