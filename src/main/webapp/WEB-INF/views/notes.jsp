<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
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
<div class="container all">
    <div class="table-responsive">
        <br/>
        <table class="table table-striped table-hover table-bordered">
            <tr>
                <td>Name</td>

                <td>Note</td>
                <td> </td>
                <%--<td>Pass</td>--%>
            </tr>
            <c:forEach items="${notes}" var="note">
                <tr class="active">
                    <td><a href="<c:url value='/edit-${note.note_id}-name' />">${note.name}</a></td>
                    <td><a href="<c:url value='/edit-${note.note_id}-data' />">${note.data}</a></td>
                    <td><a  href="<c:url value='/delete-${note.note_id}-note' />" onclick="$(this).parent().parent().remove();"><img align="middle" alt="Remove" width="20" height="20" src="<c:url value="/resources/img/trash.png"/>"></a></td>
                </tr>
            </c:forEach>
        </table>

        <a class="btn btn-info " href="<c:url value='/' />">Back</a>
        <br/>
    </div>
  </div>
</body>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
</html>
