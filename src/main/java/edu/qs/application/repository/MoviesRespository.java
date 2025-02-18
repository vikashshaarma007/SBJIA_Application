package edu.qs.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.qs.application.models.Movie;

@Repository
public interface MoviesRespository extends JpaRepository<Movie, Long>{

	List<Movie> findAll();

	
}
