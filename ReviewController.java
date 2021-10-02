package com.demo.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.book.entity.Review;
import com.demo.book.exception.ReviewNotFoundException;
import com.demo.book.service.IReviewService;

@RestController
public class ReviewController {
	@Autowired
	IReviewService reviewservice;
	
	@GetMapping("/reviews")
	ResponseEntity<List<Review>> listAllReviews() {
		return new ResponseEntity<>(reviewservice.listAllReviews(),HttpStatus.OK);
	}
	@GetMapping("/reviews/{reviewId}")
	ResponseEntity<Review> getReviewByReviewId(@PathVariable("reviewId") int reviewId) throws ReviewNotFoundException  {
		Review review = reviewservice.getReviewByReviewId(reviewId);
	 return new ResponseEntity<>(review, HttpStatus.OK); // 200 Ok
		
	}
	
// 	Review addReview(Review review)
       @PostMapping("/reviews")
       ResponseEntity<Review> addReview(@RequestBody Review review) {
    	Review rvw = reviewservice.addReview(review);
    	return new ResponseEntity<>(rvw, HttpStatus.CREATED);
	}
	
//	Review deleteReview(Review review)
	    @DeleteMapping("/reviews/{reviewId}")
	    ResponseEntity<Review> deleteReviewByReview(@PathVariable("reviewId") int reviewId) {
		Review review= reviewservice.deleteReviewByReview(reviewId);
		return new ResponseEntity<>(review, HttpStatus.OK);
	}
  //	Review updateReview(Review review)
	    @PutMapping("/reviews/{reviewId}")
        ResponseEntity<Review> updateReview(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
        Review rvw = reviewservice.updateReview(reviewId, review);
        return new ResponseEntity<>(rvw, HttpStatus.OK);
}

}
