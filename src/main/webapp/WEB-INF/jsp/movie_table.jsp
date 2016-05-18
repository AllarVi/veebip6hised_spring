<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <table class="table table-striped movie-table">
        <thead>
        <tr class="text-center">
            <th></th>
            <th>Id</th>
            <th>Nimi</th>
            <th>Zanr</th>
            <th>Hinne</th>
            <th>Kirjeldus</th>
            <%--<th></th>--%>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${requestScope.movies}" var="movie">
            <tr class="text-center">
                <td><a href="?id=${movie.id}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
                <td><c:out value="${movie.id}"/></td>
                <td><c:out value="${movie.name}"/></td>
                <td><c:out value="${movie.genre}"/></td>
                <td><c:out value="${movie.rating}"/></td>
                <td><a class="description-link" id="movie-${movie.id}">Kirjeldus</a></td>
                <%--<td><a href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="row form-container">
    <div class="col-md-6">
        <form class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">Id</label>
                <div class="col-sm-10">
                    <p class="form-control-static" id="id-value"></p>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">Kirjeldus</label>
                <div class="col-sm-10">
                    <textarea name="description" class="form-control" rows="3" id="description" placeholder="Kirjeldus" readonly></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="col-sm-2 btn btn-default" id="hide-desc">Sulge</button>
                </div>
            </div>
        </form>
    </div>
</div>
