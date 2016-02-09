<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CatchNote+</title>
</head>
<body>
<div class="all">


    <header>CatchNote+</header>
    <div class="frm">
        <form:form class="form" method="POST" modelAttribute="user">
            <input name="name" class="form-control" type="text" placeholder="Login">
            <input name="pass" class="form-control" type="password" placeholder="Password">
            <br>
            <input type="submit" value="Login" class="btn btn-success">
        </form:form>
    </div>
    <footer>
        <a href="#">forgot password</a>|
        <a href="<c:url value='/new' />">register</a>
    </footer>

</div>
</body>
</html>