<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Registration - OK!</title>
</head>

<body>

<div class="container">
    <div class="all">
    <h4> <header>${data}</header> </h4>
        <br/>

        <c:choose>
            <c:when test="${accountInfo}">
                <h3><span class="label label-success">${name}</span></h3>
                <h3><span class="label label-success">${email}</span></h3>
                <h3><span class="label label-success">${level}</span></h3>
                <br/>
                <br/>
                <h2>Go back to</h2>
                <a class="btn btn-info btn-lg" href="<c:url value='/' />">Menu</a>
                <br/>
            </c:when>
            <c:otherwise>
                <h3><span class="label label-success">${success}</span></h3>
                <br/>
                <br/>
                <h2>Go back to</h2>
                <a class="btn btn-info btn-lg" href="<c:url value='/' />">Menu</a>
                <br/>
            </c:otherwise>
        </c:choose>

    </div>
    </div>
</body>

</html>