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
    <h4> <header>Message: </header> </h4>
        <br/>
      <h3>  <span class="label label-success">${success}</span></h3>

<br/>
<br/>
    <h4><label class="label label-default">Go back to</label></h4>
        <a class="btn btn-primary btn-lg" href="<c:url value='/list' />">List of All Users</a>
        <a class="btn btn-info btn-lg" href="<c:url value='/' />">Menu</a>
    <br/>
    </div>
    </div>
</body>

</html>