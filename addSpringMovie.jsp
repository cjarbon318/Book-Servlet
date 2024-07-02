<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Movie</title>
</head>
<body>
    <h1>Add New Movie</h1>
    <form action="/SpringMovie/movies/addSpringMovie" method="post">
        
        Title: <input type="text" name="title"><br>
        Actor: <input type="text" name="actor"><br>
        Actress: <input type="text" name="actress"><br>
        Year: <input type="number" name="year"><br> 
        <input type="submit" value="Add Movie">
    </form>
    
    <!-- Confirmation message -->
    <c:if test="${not empty confirmationMessage}">
        <p style="color: green; font-weight: bold;">${confirmationMessage}</p>
    </c:if>
    
    <p><a href="/SpringMovie/">Back to Home</a></p>

</body>
</html>
