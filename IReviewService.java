package com.demo.book.service;

import java.util.List;

import com.demo.book.entity.Review;
import com.demo.book.exception.ReviewNotFoundException;

public interface IReviewService {
List<Review> listAllReviews();

	

	Review deleteReviewByReview(int reviewId);

	Review updateReview(int reviewId, Review review);

	Review getReviewByReviewId(int reviewId) throws ReviewNotFoundException;



	Review addReview(Review review);

}
