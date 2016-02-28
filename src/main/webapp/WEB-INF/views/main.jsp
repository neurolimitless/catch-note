<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="utf-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta charset='utf-8'>
    <title>CathNote+ login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/mainstyle.css"/>">
</head>
<body>
<div id="carbonForm">
    <h1>CatchNote+</h1>
    <form:form modelAttribute="note" action="newnote" method="post" id="signupForm">
        <div class="fieldContainer">
            <div class="formRow two">
                <form:input path="name" type="text" placeholder="Name of the new note"/>
            </div>
            <div class="formRow two">
                <form:textarea path="data" placeholder="Note"/>
            </div>
        </div>
        <div class="signupButton">
            <input type="submit" name="submit" class="submit" value="Add">
            <input type="button" name="submit" class="submit" onclick="document.getElementById('data').value ='';
                   document.getElementById('name').value ='';" value="Clear"/>
        </div>
    </form:form>
</div>
<footer class="footer">
    <h2 id="home"><a href="#">Login page</a> <a href="#">Register</a> <a href="#">Forgot password</a></h2>
</footer>
<footer class="footerTwo">
    <form method="post"/>
    <h2 id="home">
        <a href="#" onclick="$(this).closest('form').submit()">Logout</a>

        <a href="<c:url value='/upload'/>">Upload</a> <a href="<c:url value='/notes'/>">My Notes</a></h2>
</footer>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/script1.js"/>"></script>


</body>

</html>
