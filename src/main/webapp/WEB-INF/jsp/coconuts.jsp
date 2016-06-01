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

        .form-container-add-document {
            display: none;
        }

        .log-in-form {
            border: 1px solid #cacaca;
            padding: 1rem;
            border-radius: 3px;
        }
    </style>

    <script>
        (function(document) {
            'use strict';

            var LightTableFilter = (function(Arr) {

                var _input;

                function _onInputEvent(e) {
                    _input = e.target;
                    var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
                    Arr.forEach.call(tables, function(table) {
                        Arr.forEach.call(table.tBodies, function(tbody) {
                            Arr.forEach.call(tbody.rows, _filter);
                        });
                    });
                }

                function _filter(row) {
                    var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
                    row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
                }

                return {
                    init: function() {
                        var inputs = document.getElementsByClassName('light-table-filter');
                        Arr.forEach.call(inputs, function(input) {
                            input.oninput = _onInputEvent;
                        });
                    }
                };
            })(Array.prototype);

            document.addEventListener('readystatechange', function() {
                if (document.readyState === 'complete') {
                    LightTableFilter.init();
                }
            });

        })(document);
    </script>

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
        </ul>
    </section>
</nav>

<div>

    <c:choose>
        <c:when test="${document.name != null}">
            <jsp:include page="form_coconut.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="table_coconut.jsp"/>
        </c:otherwise>
    </c:choose>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script>

    <%--$(".edit-document").click(function () {--%>
        <%--<jsp:include page="form_document.jsp"/>--%>
    <%--}--%>

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

    //    Add document

    function showAddDocument() {
        $(".form-container-add-document").show();
    }

    function initDocTypes(data) {
        $.each(data, function () {
            $('#docTypes').append(new Option(this.typeName, this.typeName));
        });
    }

    var getDocTypes = function () {
        $.get("${pageContext.request.contextPath}/documentservice/doctype", function (data) {
            initDocTypes(data);
        }).fail(function () {
            console.log("Viga dokumendi tüüpide küsimisel!");
        });
    };

    function initDocSubjectTypes(data) {
        $.each(data, function () {
            $('#docSubjectType').append(new Option(this.subjectTypeName, this.id));
        });
    }

    var getDocSubjectTypes = function () {
        $.get("${pageContext.request.contextPath}/documentservice/docsubjecttype", function (data) {
            initDocSubjectTypes(data);
        }).fail(function () {
            console.log("Viga subjekti tüüpide küsimisel!");
        });
    };

    function initDocSubjects(data) {
        $.each(data, function () {
            $('#docSubject').append(new Option(this.subjectName, this.subjectName));
        });
    }

    var getDocSubjects = function () {
        $.get("${pageContext.request.contextPath}/documentservice/docsubject", function (data) {
            initDocSubjects(data);
        }).fail(function () {
            console.log("Viga subjektide küsimisel!");
        });
    };

    $(".add-document").click(function () {
        console.log("Add document button clicked");

        getDocTypes();

        getDocSubjects();

        getDocSubjectTypes();

        showAddDocument();
    });

    //      Delete document

    $(".delete-document").click(function () {
        console.log("Delete document button clicked");

        var documentId = $(this).attr('id').split("-")[1];;
        console.log("Delete document button clicked id " + documentId);

        $(this).closest('tr').remove();

        $.get("${pageContext.request.contextPath}/delete?id=" + documentId, function (data) {
            deleteDocument(data);
        });

        console.log("Delete document button clicked path " + "${pageContext.request.contextPath}/delete?id=" + documentId);

    });

    function deleteDocument(data) {
        console.log("Deleting ..");
        $("#id-value").text(data.id);

    }

    //      Edit document

    $(".edit-document").click(function () {
        console.log("Edit document button clicked");

        var documentId = $(this).attr('id').split("-")[1];;
        console.log("Edit document button clicked id " + documentId);

        $.get("${pageContext.request.contextPath}/s?id=" + documentId, function (data) {
            editDocument(data);
        }).fail(function () {
            alert("Viga!");
        });

        console.log("Edit document button clicked path " + "${pageContext.request.contextPath}/s?id=" + documentId);

    });

</script>

<!-- Compressed JavaScript -->
<script src="https://cdn.jsdelivr.net/foundation/6.2.1/foundation.min.js"></script>

</body>
</html>