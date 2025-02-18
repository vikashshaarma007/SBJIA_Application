package edu.qs.application.service;

import java.util.List;

import edu.qs.application.models.Movie;


public interface MoviesService {
	 List<Movie> getAllMovies();
	 Movie SaveMovies(Movie movies);
	 Movie getMovieById(long id);
	 Movie updateMovieByid(long id,Movie movie);
	 void delectMovieById(long id);
	

}
