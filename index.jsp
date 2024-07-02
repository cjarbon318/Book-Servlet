<%-- 
    Document   : index
    Created on : Jun 21, 2024, 1:39:15 PM
    Author     : carliarbon
--%>

<!DOCTYPE html>
<html>
<head>
    <title>Movie App</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Welcome to the SpringMovie App!</h1>
    <p>Select an option below:</p>
    <ul>
        <li><a href="${pageContext.request.contextPath}/movies/list">View Movie List</a></li>
        <li><a href="${pageContext.request.contextPath}/movies/addMovie">Add a New Movie</a></li>
        <li><a href="${pageContext.request.contextPath}/movies/searchMovie">Search Movies</a></li>
    </ul>
</body>
</html>
