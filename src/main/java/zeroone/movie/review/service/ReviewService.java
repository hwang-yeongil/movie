package zeroone.movie.review.service;

import org.springframework.http.ResponseEntity;

import zeroone.movie.review.dto.AddReviewFormDto;

public interface ReviewService {
	ResponseEntity save(AddReviewFormDto formDto);
}
