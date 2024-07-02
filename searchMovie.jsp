<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Movies</title>
</head>
<body>
    <h2>Search Movies</h2>
    <form action="/SpringMovie/movies/search" method="POST"> 
        <label for="searchBy">Search By:</label>
        <select name="searchBy" id="searchBy">
            <option value="title">Title</option>
            <option value="actor">Actor</option>
            <option value="actress">Actress</option>
        </select>
        <label for="keyword">Keyword:</label>
        <input type="text" name="keyword" id="keyword">
        <button type="submit">Search</button>
    </form>
</body>
</html>
