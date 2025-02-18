package edu.qs.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.qs.application.dto.ReviewDto;
import edu.qs.application.models.Movie;
import edu.qs.application.models.Review;
import edu.qs.application.service.MoviesService;
import edu.qs.application.service.ReviewSevice;





@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
	@Autowired
    private ReviewSevice reviewSevice;
	@Autowired
	private MoviesService movieService;
 
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewSevice.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewSevice.getReviewById(id);
    }

    @PostMapping
    public Review addReview(@RequestBody ReviewDto reviewsDto) {
        Movie movie = movieService.getMovieById(reviewsDto.getMovieId());  // ✅ Fetch Movie
        if (movie == null) {
            throw new RuntimeException("Movie with ID " + reviewsDto.getMovieId() + " not found");
        }

        Review review = new Review();
        review.setMovie(movie); 
        review.setReviewerName(reviewsDto.getReviewerName());
        review.setComment(reviewsDto.getComment());
        review.setRating(reviewsDto.getRating());
        return reviewSevice.addReview(review);
    } 

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody ReviewDto reviewDto) {
        
        Review existingReview = reviewSevice.getReviewById(id);
        if (existingReview == null) {
            throw new RuntimeException("Review with ID " + id + " not found");
        }

        
        if (reviewDto.getMovieId() != null) {
            Movie movie = movieService.getMovieById(reviewDto.getMovieId());
            if (movie == null) {
                throw new RuntimeException("Movie with ID " + reviewDto.getMovieId() + " not found");
            }
            existingReview.setMovie(movie);  
        }

       
        existingReview.setReviewerName(reviewDto.getReviewerName());
        existingReview.setComment(reviewDto.getComment());
        existingReview.setRating(reviewDto.getRating());

        
        return reviewSevice.updateReview(id,existingReview);
    }


    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewSevice.delectReviewById(id);
    }

}
