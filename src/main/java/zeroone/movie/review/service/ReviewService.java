package zeroone.movie.review.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import zeroone.movie.review.domain.Review;
import zeroone.movie.review.dto.AddReviewFormDto;

public interface ReviewService {
	ResponseEntity save(AddReviewFormDto formDto);
	List<Review> findListbyid(Long id);
}
