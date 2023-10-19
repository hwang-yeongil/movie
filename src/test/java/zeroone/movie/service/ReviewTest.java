package zeroone.movie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import zeroone.movie.review.domain.Review;
import zeroone.movie.review.repository.ReviewRepository;
import zeroone.movie.review.service.ReviewService;

@SpringBootTest
@Transactional
public class ReviewTest {
	
	private ReviewService reviewService;
	@Autowired
	ReviewRepository reviewRepository;
	
	@Test
	public void saveTest() throws Exception{
//		reviewService.update(1L,"testtestste", "123123123");
		

		
	}
}
