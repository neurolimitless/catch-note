<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>User Registration</title>

</head>

<body>

<div class="container-fluid">
    <div class="all">
        <div class="header-borderless">Registration Form</div>

        <form:form class="form" method="POST" modelAttribute="user">
            <form:input type="hidden" path="id" id="id"/>


            <div class="text-center ">
                <form:input class="form-control" path="name" id="name" placeholder="Username"/>
                <form:errors class="form-control" path="name" cssClass="error"/>
                <br/>

                <form:input class="form-control" type="password" path="pass" id="pass" placeholder="Password"/>
                <form:errors class="form-control" path="pass" cssClass="error"/>
                <br/>
                <form:input class="form-control" path="email" id="email" placeholder="Email"/>
                <form:errors class="form-control" path="email" cssClass="error"/>
            </div>
            <br/>
            <c:choose>
                <c:when test="${edit}">
                    <input class="btn btn-default btn-lg" type="submit" value="Update"/>
                </c:when>
                <c:otherwise>
                    <input type="submit" class="btn btn-success " value="Register"/>
                </c:otherwise>
            </c:choose>

            <a class="btn btn-info " href="<c:url value='/' />">Back</a>

        </form:form>


    </div>
</div>

</body>
</html>