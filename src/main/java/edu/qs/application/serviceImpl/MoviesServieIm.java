package edu.qs.application.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.qs.application.models.Movie;
import edu.qs.application.repository.MoviesRespository;
import edu.qs.application.service.MoviesService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MoviesServieIm implements MoviesService {
	
	@Autowired
	 private MoviesRespository moviesRespository;

	@Override
	public List<Movie> getAllMovies() {
		
		return moviesRespository.findAll();
	}

	@Override
	public Movie SaveMovies(Movie movies) {
		
		return moviesRespository.save(movies);
	}

	@Override
	public Movie getMovieById(long id) {
		
		return moviesRespository.findById(id).orElseThrow(()-> new EntityNotFoundException("Movie not found with Id:" +id));
	}

	@Override
	public Movie updateMovieByid(long id, Movie movie) {
		
		Movie movies = getMovieById(id);
		movie.setTitle(movies.getTitle());
		movie.setGenre(movies.getGenre());
		movie.setReleaseYear(movies.getReleaseYear());
		return moviesRespository.save(movies);
	}

	@Override
	public void delectMovieById(long id) {
		Movie movie = getMovieById(id);
		moviesRespository.delete(movie);
		
	}

}
