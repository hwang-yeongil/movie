package zeroone.movie.review.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import zeroone.movie.review.domain.Review;
import zeroone.movie.review.dto.AddReviewFormDto;
import zeroone.movie.review.dto.DetailDto;
import zeroone.movie.review.dto.ReviewListDto;
import zeroone.movie.review.dto.UpdateDto;

public interface ReviewService {
	ResponseEntity save(AddReviewFormDto formDto);
	List<ReviewListDto> getAll();
	List<ReviewListDto> getAllPk(Long id);
	DetailDto getDetail(Long id);
	ResponseEntity remove(Long id);
//	void update(Long review_pk, String rv_title, String rv_content);
//	List<Review> findByMoviePk(Long movie_pk);
	UpdateDto update(Long review_pk);
}
 