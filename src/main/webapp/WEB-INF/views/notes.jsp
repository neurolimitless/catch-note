<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles2.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Menu</title>


</head>


<body>
<div class="dialog">
    <div class="hdDial"><span>Действительно хотите удалить заметку?</span>
        <a href="" id="closeDialog"></a>
    </div>
    <div class="contDial">
        <br>
        <div class="text">Вы действительно хотите <strong>УДАЛИТЬ</strong> заметку?
        </div>
        <div class="butn">

        </div>
    </div>
</div>
<div class="container all">
    <br>
    <div class="table-responsive">
        <table class="table table-striped table-hover table-bordered">
            <tr>
                <th class="col-md-1">ID</th>
                <th class="col-md-2">Name</th>

                <th class="col-md-12">Note</th>
                <th class="col-md-1">Actions</th>
                <%--<td>Pass</td>--%>
            </tr>
            <c:forEach items="${notes}" var="note">
                <tr class="active">

                    <td id="id">
                        <div id="noteId">${note.note_id}</div>
                    </td>
                    <td>
                        <div id="editName" class="editName" content="${note.note_id}"><a href="#"> ${note.name}</a>
                        </div>
                    </td>
                    <td>
                        <div id="editData" class="editData" content="${note.note_id}"><a href="#"> ${note.data}</a>
                        </div>
                    </td>
                    <td>
                        <div id="deleteNote" class="deleteNote" content="${note.note_id}">
                            <button id="opnDial" >
                                <img align="middle" alt="Remove" width="20" height="20"
                                     src="<c:url value="/resources/img/trash.png"/>"></button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div><a class="btn btn-info " href="<c:url value='/' />">Back</a></div>
        <br>
    </div>
</div>
</body>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.2.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/script2.js"/>"></script>

</html>
