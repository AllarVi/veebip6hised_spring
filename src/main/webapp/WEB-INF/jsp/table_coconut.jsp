<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <table class="table table-striped coconut-table">
        <thead>
        <tr class="text-center">
            <th></th>
            <th>Id</th>
            <th>Nimi</th>
            <th>Kaal</th>
            <th>Hinnang</th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${requestScope.coconuts}" var="coconut">
            <tr class="text-center">
                <td><a href="?id=${coconut.id}"><button class="tiny button" aria-hidden="true">Muuda</button></a></td>
                <td><c:out value="${coconut.id}"/></td>
                <td><c:out value="${coconut.name}"/></td>
                <td><c:out value="${coconut.weight}"/></td>
                <td><c:out value="${coconut.rating}"/></td>
                <td><a class="description-link tiny button" id="coconut-${coconut.id}">Kirjeldus</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="row form-container">
    <div class="col-md-6">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">Id:
                    <span class="form-control-static" id="id-value"></span></label>
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
