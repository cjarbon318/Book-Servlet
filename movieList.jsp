<%-- 
    Document   : movieList
    Created on : Jun 21, 2024, 1:39:44 PM
    Author     : carliarbon
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie List</title>
</head>
<body>
    <h1>Movie List</h1>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Actor</th>
            <th>Actress</th>
            <th>Year</th>
        </tr>
        <c:forEach var="movie" items="${movies}">
            <tr>
                <td>${movie.title}</td>
                <td>${movie.actor}</td>
                <td>${movie.actress}</td>
                <td>${movie.year}</td>
            </tr>
        </c:forEach>
    </table>

    <p><a href="/SpringMovie/">Back to Home</a></p>

</body>
</html>
