package edu.qs.application.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.qs.application.models.Review;
import edu.qs.application.repository.ReviewRepository;
import edu.qs.application.service.ReviewSevice;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ReviewServiceImpl implements ReviewSevice {

	@Autowired
    private ReviewRepository reviewRepository;


	@Override
	public Review addReview(Review review) {
		return reviewRepository.save(review);
	}

	
	public Review getReviewById(long id) {
		return reviewRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Review not found with id" +id));
	}

	public Review updateReview(Long id, Review updatedReview) {
		Review existingReview = getReviewById(id);
		updatedReview.setComment(existingReview.getComment());
		updatedReview.setRating(existingReview.getRating());
		return reviewRepository.save(existingReview);
        
        
	}

	@Override
	public void delectReviewById(long id) {
		 reviewRepository.deleteById(id);
	}


	@Override
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
		
	}
}
