package edu.qs.application.service;

import java.util.List;


import edu.qs.application.models.Review;

public interface ReviewSevice {
	
	 List<Review> getAllReviews();
	 Review addReview(Review review);
	 Review getReviewById(long id);
	 
	void delectReviewById(long id);
	Review updateReview(Long id, Review updatedReview);

}
