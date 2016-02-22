<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="false"%>
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
        <br>
    <form method="post">
  <input type="submit" class="btn btn-default" value="Logout"/>
  <a href="<c:url value='/upload'/>" type="button" class="btn btn-primary">Upload</a>
  <a href="<c:url value='/notes'/>" type="button" class="btn btn-primary">My Notes</a>
    </form>
    <br/>   <br/>
        <div class="form-group">
            <form:form class="form" modelAttribute="note" action="newnote" method="post">

                <form:input class="form-control" type="text" path="name" id="name" placeholder="Name of the new note"/>
                <form:input class="form-control" type="text" path="data" id="data" placeholder="Note"/>
                <br/>
                <input type="submit" class="btn btn-success" value="Create"/>
                <input type="button" class="btn btn-warning" value="Clear" onclick="document.getElementById('data').value ='';"/>
                </form:form>


            </form>


        </div>

  </div>
</body>
</html>
