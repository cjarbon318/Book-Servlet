package com.hw4.springmovies.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movie> getAllMovies() {
        String sql = "SELECT * FROM springmovies";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Movie movie = new Movie();
            movie.setTitle(rs.getString("title"));
            movie.setActor(rs.getString("actor"));
            movie.setActress(rs.getString("actress"));
            movie.setYear(rs.getInt("year"));
            return movie;
        });
    }

    public void addMovie(Movie movie) {
        String sql = "INSERT INTO springmovies(title, actor, actress, year) VALUES(?,?,?,?)";

        jdbcTemplate.update(sql, movie.getTitle(), movie.getActor(), movie.getActress(), movie.getYear());
        System.out.println("Movie added successfully!");
    }

    public List<Movie> searchByTitle(String title) {
        return searchMovies("title", title);
    }

    public List<Movie> searchByActor(String actor) {
        return searchMovies("actor", actor);
    }

    public List<Movie> searchByActress(String actress) {
        return searchMovies("actress", actress);
    }

    private List<Movie> searchMovies(String field, String keyword) {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM springmovies WHERE " + field + " LIKE ?";
        jdbcTemplate.query(sql, new Object[]{"%" + keyword + "%"}, (rs, rowNum) -> {
            Movie movie = new Movie();
            movie.setTitle(rs.getString("title"));
            movie.setActor(rs.getString("actor"));
            movie.setActress(rs.getString("actress"));
            movie.setYear(rs.getInt("year"));
            movies.add(movie);
            return null;
        });
        return movies;
    }
}
