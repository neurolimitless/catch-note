<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>UserList</title>


</head>


<body>

<div class="container">
    <div class="all-60">

    <h5 class="header-borderless">List of Users</h5>
        <div class="table-responsive">
    <table class="table table-striped table-hover table-condensed">
        <tr>
            <td>Name</td>
            <td>Email</td>
            <td>Pass</td>

        </tr>

        <c:forEach items="${users}" var="user">
            <tr class="active">
                <td>${user.name}</td>
                               <td><a href="<c:url value='/edit-${user.email}-user' />">${user.email}</a></td>
                <td><a href="<c:url value='/edit-${user.pass}-user' />">${user.pass}</a></td>
            </tr>
        </c:forEach>

    </table>
            <div class="bodycontainer scrollable">
        </div>
        </div>
      <form class="form-inline">

    <div class="form-group">
        <input type="submit" class="btn btn-success btn-lg" value="Register">
    <a class="btn btn-success btn-lg" href="<c:url value='/new' />">Add New User</a>
        <a class="btn btn-info btn-lg" href="<c:url value='/' />">Menu</a>
    </div>
      </form>


</div>
</div>
</body>
</html>