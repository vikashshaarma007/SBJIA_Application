package edu.qs.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.qs.application.models.Movie;
import edu.qs.application.service.MoviesService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired 
	private MoviesService moviesService;
	
	@GetMapping
	public List<Movie> getAllMovies(){
		return moviesService.getAllMovies();
	}
	@PostMapping
	public Movie saveMovie(@RequestBody Movie movie) {
		 return moviesService.SaveMovies(movie);
	 }
	@GetMapping("/{id}")
	public Movie getMovieById (@PathVariable long id) {
		return moviesService.getMovieById(id);
	}
	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable long id, @RequestBody Movie movie) {
		return moviesService.updateMovieByid(id, movie);
	}
	
	public void delectMovie(@PathVariable long id) {
		moviesService.delectMovieById(id);
	}
	

}
