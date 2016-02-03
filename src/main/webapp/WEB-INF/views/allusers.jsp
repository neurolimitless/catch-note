<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>UserList</title>

    <style>
        tr:first-child {
            font-weight: bold;
            background-color: #C6C9C4;
        }

        body {
            background: url(http://puu.sh/mStDL/2055fea916.png);
        }

    </style>

</head>


<body>
<div class="container">
    <h2>List of Users</h2>
    <table class="table">
        <tr>
            <td>NAME</td>
            <td>Joining Date</td>
            <td>Salary</td>
            <td>Email</td>
            <td></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr class="active">
                <td>${user.name}</td>
                <td>${user.joiningDate}</td>
                <td>${user.salary}</td>
                <td><a href="<c:url value='/edit-${user.email}-user' />">${user.email}</a></td>
                <td><a href="<c:url value='/delete-${user.email}-user' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a class="btn btn-primary btn-lg" href="<c:url value='/new' />">Add New User</a>
</div>
</body>
</html>