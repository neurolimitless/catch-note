<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles2.css" />">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
        integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
        integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
          integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
          crossorigin="anonymous"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Menu</title>


</head>


<body>
<br><br>

<div class="dialog">
    <div class="hdDial"><span>Действительно хотите удалить заметку?</span>
        <a href="" id="closeDialog"></a>
    </div>
    <div class="contDial">
        <br>
        <div class="text">Вы действительно хотите <strong>УДАЛИТЬ</strong> заметку?
        </div>
        <div class="butn">
            <button class="inn" id="yes" onclick="location.href='<c:url value='/delete-${note.note_id}-note' />'">OK</button>
            <button class="inn" id="no">Cancel</button>
        </div>
    </div>

</div>
<div class="container all">
    <div class="table-responsive">
        <br/>
        <table class="table table-striped table-hover table-bordered">
            <tr>
                <th class="col-md-1">ID</th>
                <th class="col-md-3">Name</th>

                <th class="col-md-12">Note</th>
                <th class="col-md-1">Actions </th>
                <%--<td>Pass</td>--%>
            </tr>
            <c:forEach items="${notes}" var="note">
                <tr class="active">
                    <td>${note.note_id}</td>
                    <td><a href="<c:url value='/edit-${note.note_id}-name' />">${note.name}</a></td>
                    <td><a href="<c:url value='/edit-${note.note_id}-data' />">${note.data}</a></td>
                    <td><button id="opnDial" >
                        <img align="middle" alt="Remove" width="20" height="20" src="<c:url value="/resources/img/trash.png"/>"></button>

                    </td>
                </tr>
            </c:forEach>
        </table>

       <div> <a class="btn btn-info " href="<c:url value='/' />">Back</a> </div>
       <br>
    </div>
  </div>
</body>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/script2.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.2.0.js"/>"></script>

</html>
