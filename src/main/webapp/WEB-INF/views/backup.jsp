<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
      <div class="table-responsive">
        <table class="table">
          <tr>

            <td><form:input class="form-control" path="name" id="name" placeholder="Username"/></td>
            <td><form:errors class="form-control" path="name" cssClass="error"/></td>
          </tr>

          <tr>

            <td><form:input class="form-control" type="password" path="pass" id="pass" placeholder="Password"/></td>
            <td><form:errors class="form-control" path="pass" cssClass="error"/></td>
          </tr>

          <tr>

            <td><form:input class="form-control" path="email" id="email" placeholder="Email"/></td>
            <td><form:errors class="form-control" path="email" cssClass="error"/></td>
          </tr>

          <tr>

            <td colspan="2">
              <c:choose>
                <c:when test="${edit}">
                  <input class="btn btn-default btn-lg" type="submit" value="Update"/>
                </c:when>
                <c:otherwise>
                  <input type="submit" class="btn btn-success btn-lg" value="Register"/>
                </c:otherwise>
              </c:choose>
              <a class="btn btn-warning btn-lg" href="<c:url value='/list' />">List of All Users</a>
              <a class="btn btn-info btn-lg" href="<c:url value='/' />">Back</a>
            </td>


          </tr>
        </table>

      </div>
    </form:form>


  </div>
</div>

</body>
</html>


<form:input class="form-control" path="name" id="name" placeholder="Login"/>
<form:errors class="form-control" path="name" cssClass="error"/>
<form:input class="form-control" path="pass" id="pass" type="password" placeholder="Password"/>
<form:errors class="form-control" path="pass" cssClass="error"/>