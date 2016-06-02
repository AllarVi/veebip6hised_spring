<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .document-table th {
        text-align: center;
    }

    .error {
        color: #ff5c33;
    }

    .form-container {
        display: none;
    }

    .form-container-add-document {
        display: none;
    }

    .log-in-form {
        border: 1px solid #cacaca;
        padding: 1rem;
        border-radius: 3px;
    }
</style>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/foundation/6.2.1/foundation.min.css">



<c:if test="${not empty sessionScope.errors}">
    <div class="alert alert-danger">
        <strong>Viga!</strong> Kontrolli, et kõik väljad oleksid täidetud.
    </div>
</c:if>

Viga dokumendi lisamisel! Kontrolli, et kõik väljad oleksid täidetud.

        <form:form id="addDocumentForm" action="${pageContext.request.contextPath}/documentservice/add"
                   modelAttribute="document" method="POST">
            <div class="row column log-in-form">
                <label>Nimi
                    <form:input path="name" type="text" placeholder="Name"></form:input>
                    <form:errors path="name"><p class="error">Nimi peab jääma 1 ja 30 tähemärgi vahele!</p></form:errors>

                </label>
                <label>Kirjeldus
                    <form:input path="description" type="text" placeholder="Description"></form:input>
                    <form:errors path="description"><p class="error">Kirjeldus ei tohi olla tühi!</p></form:errors>

                </label>
                <label>Dokumendi tüüp
                    <form:input type="text" path="type" id="docTypes"></form:input>
                    <form:errors path="type"><p class="error">Tüüp ei tohi olla tühi!</p></form:errors>
                </label>
                <label>Failinimi
                    <form:input path="filename" type="text" placeholder="Filename"></form:input>
                    <form:errors path="filename"><p class="error">Failinimi ei tohi olla tühi!</p></form:errors>

                </label>
                <label>Subjekt
                    <form:input type="text" path="subject" id="docSubject"></form:input>
                    <form:errors path="subject"><p class="error">Subjekt ei tohi olla tühi!</p></form:errors>

                </label>
                <label>Seos
                    <form:input type="text" path="relation" id="docSubjectType"></form:input>
                    <form:errors path="relation"><p class="error">Seos ei tohi olla tühi!</p></form:errors>
                </label>
                <p><input type="submit" class="button expanded" value="Lisa dokument"></p>
            </div>
        </form:form>
