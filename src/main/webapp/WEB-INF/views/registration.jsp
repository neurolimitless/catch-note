<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>User Registration</title>

  <style>

    body {
      background: url(http://puu.sh/mStDL/2055fea916.png);
    }
  </style>

</head>

<body>
<div class="container">
<h2>Registration Form</h2>

<form:form class="form-inline" method="POST" modelAttribute="user">
  <form:input type="hidden" path="id" id="id"/>
  <table class="table">
    <tr>
      <td><label for="name">Name: </label> </td>
      <td><form:input class="form-control" path="name" id="name"/></td>
      <td><form:errors class="form-control" path="name" cssClass="error"/></td>
    </tr>

    <tr>
      <td><label for="joiningDate">Joining Date: </label> </td>
      <td><form:input class="form-control" path="joiningDate" id="joiningDate"/></td>
      <td><form:errors class="form-control" path="joiningDate" cssClass="error"/></td>
    </tr>

    <tr>
      <td><label for="salary">Salary: </label> </td>
      <td><form:input class="form-control" path="salary" id="salary"/></td>
      <td><form:errors class="form-control" path="salary" cssClass="error"/></td>
    </tr>

    <tr>
      <td><label for="email">Email: </label> </td>
      <td><form:input class="form-control" path="email" id="email"/></td>
      <td><form:errors class="form-control" path="email" cssClass="error"/></td>
    </tr>

    <tr>
      <td colspan="3">
        <c:choose>
          <c:when test="${edit}">
            <input class="btn btn-default" type="submit" value="Update"/>
          </c:when>
          <c:otherwise>
            <input type="submit" class="btn btn-default" value="Register"/>
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
  </table>
</form:form>
<br/>
<br/>
<label class="label label-default">Go back to</label>  <a class="btn btn-primary btn-lg" href="<c:url value='/list' />">List of All Users</a>
</div>
</body>
</html>