<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
</head>
<body>
    <h2>Search Results</h2>
    <c:if test="${not empty searchResults}">
        <c:forEach var="movie" items="${searchResults}">
            <div>
                <h3>Title: ${movie.title}</h3>
                <p>Actor: ${movie.actor}</p>
                <p>Actress: ${movie.actress}</p>
                <p>Year: ${movie.year}</p>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${empty searchResults}">
        <p>No movies found for the provided search criteria.</p>
    </c:if>
    
    <p><a href="/SpringMovie/">Back to Home</a></p>
</body>
</html>
