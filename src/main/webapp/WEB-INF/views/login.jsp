<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="utf-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset='utf-8'>
    <title>CathNote+ login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/loginstyle.css"/>">
</head>

<body>

<div id="carbonForm">
    <h1>CatchNote+</h1>

        <form:form class="form" method="POST" id="signupForm" modelAttribute="user">
        <div class="fieldContainer">

            <div class="formRow">
                <div class="label">
                    <label for="name">Login:</label>
                </div>

                <div class="field">
                    <input type="text" name="name" id="name">
                </div>
            </div>


            <div class="formRow">
                <div class="label">
                    <label for="pass">Password:</label>
                </div>

                <div class="field">
                    <input type="password" name="pass" id="pass" />
                </div>
            </div>


        </div> <!-- Closing fieldContainer -->

        <div class="signupButton">
            <input type="submit" name="submit" id="submit" value="Sign in" >
        </div>
    </form:form>

</div>
<footer>
    <h2 id="home"><a href="#">Login page</a>  <a href="<c:url value='/new' />">Register</a> <a href="#">Forgot password</a> </h2>
</footer>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>



</body>
</html>
