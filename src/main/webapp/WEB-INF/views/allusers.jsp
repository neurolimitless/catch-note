<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
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
            </div>
            <div class="btn-group">
                <a class="btn btn-success " href="<c:url value='/new' />">Add New User</a>
                <a class="btn btn-info " href="<c:url value='/' />">Menu</a>
            </div>
        </div>
    </div>
</body>
</html>