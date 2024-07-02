package com.hw4.springmovies;

import com.hw4.springmovies.model.Movie;
import com.hw4.springmovies.model.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieDAO movieDAO;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/list")
    public String listMovies(Model model) {
        List<Movie> movies = movieDAO.getAllMovies();
        model.addAttribute("movies", movies);
        return "movieList";
    }

    @GetMapping("/addSpringMovie") 
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie()); 
        return "addSpringMovie"; 
    }

    @GetMapping("/addMovie") 
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie()); 
        return "addSpringMovie"; 
    }

    @PostMapping("/addSpringMovie")
    public String addMovie(@ModelAttribute("movie") Movie movie, Model model) {
        movieDAO.addMovie(movie);
        model.addAttribute("confirmationMessage", "Movie added successfully!");
        return "addSpringMovie"; 
    }

    @GetMapping("/searchMovie")
    public String showSearchForm(Model model) {
        
        return "searchMovie"; 
    }

    @PostMapping("/search")
    public String searchMovies(@RequestParam String searchBy, @RequestParam String keyword, Model model) {
        List<Movie> searchResults;

        switch (searchBy) {
            case "title":
                searchResults = movieDAO.searchByTitle(keyword);
                break;
            case "actor":
                searchResults = movieDAO.searchByActor(keyword);
                break;
            case "actress":
                searchResults = movieDAO.searchByActress(keyword);
                break;
            default:
                System.out.println("Invalid search criteria.");
                return "errorPage";
        }

        if (searchResults.isEmpty()) {
            System.out.println("No results found for the provided search criteria.");
        }

        model.addAttribute("searchResults", searchResults);
        return "searchResults"; 
    }
}