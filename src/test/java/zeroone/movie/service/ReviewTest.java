package zeroone.movie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import zeroone.movie.review.domain.Review;
import zeroone.movie.review.service.ReviewService;

@SpringBootTest
@Transactional
public class ReviewTest {
	
	private ReviewService reviewService;
	
}
