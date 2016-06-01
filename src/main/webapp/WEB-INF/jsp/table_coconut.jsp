<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <input type="search" class="light-table-filter" data-table="order-table" placeholder="Filter">
    <table class="table table-striped coconut-table order-table">

        <thead>
        <tr class="text-center">
            <th>Documendi id</th>
            <th>Nimi</th>
            <th>Kirjeldus</th>
            <th>Tüüp</th>
            <th>Failinimi</th>
            <th>Subjekt</th>
            <th>Seos</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${requestScope.documents}" var="document">
            <tr class="text-center">
                <td><c:out value="${document.id}"/></td>
                <td><c:out value="${document.name}"/></td>
                <td><c:out value="${document.description}"/></td>
                <td><c:out value="${document.type}"/></td>
                <td><c:out value="${document.filename}"/></td>
                <td><c:out value="${document.subject}"/></td>
                <td><c:out value="${document.relation}"/></td>
                <td><a href="edit?id=${document.id}">
                    <button class="edit-document tiny button" aria-hidden="true">Muuda</button>
                </a></td>
                <td><a type="submit" action="delete" class="delete-document tiny button" id="document-${document.id}">
                    Kustuta
                </a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <td><a>
        <button class="add-document tiny button" aria-hidden="true">Lisa
        </button>
    </a></td>
</div>

<div class="row form-container">
    <div class="col-md-6">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">Id:
                    <span name="id-value" class="form-control-static" id="id-value"></span></label>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">Kirjeldus</label>
                <div class="col-sm-10">
                    <textarea name="description" class="form-control" rows="3" id="description" placeholder="Kirjeldus"
                              readonly></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="button" id="hide-desc">Sulge</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="row form-container-add-document">
    <div class="medium-6 medium-centered large-4 large-centered columns">

        <form:form id="addDocumentForm" action="${pageContext.request.contextPath}/coconutservice/add"
                   modelAttribute="document" method="POST">
            <div class="row column log-in-form">
                <label>Nimi
                    <form:input path="name" type="text" placeholder="Name"></form:input>
                </label>
                <label>Kirjeldus
                    <form:input path="description" type="text" placeholder="Description"></form:input>
                </label>
                <label>Dokumendi tüüp
                    <form:select path="type" id="docTypes"></form:select>
                </label>
                <label>Failinimi
                    <form:input path="filename" type="text" placeholder="Filename"></form:input>
                </label>
                <label>Subjekt
                    <form:select path="subject" id="docSubject"></form:select>
                </label>
                <label>Seos
                    <form:select path="relation" id="docSubjectType"></form:select>
                </label>
                <p><input type="submit" class="button expanded" value="Add document"></p>
            </div>
        </form:form>

    </div>
</div>