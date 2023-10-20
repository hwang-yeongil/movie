package zeroone.movie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
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
//@Transactional
public class ReviewTest {

	private ReviewService reviewService;
	@Autowired
	ReviewRepository reviewRepository;

//	@Test
	public void saveTest() throws Exception{
//		reviewService.update(1L,"testtestste", "123123123");
		Review review = reviewRepository.findById(1L).get();
		
		Review test = Review.builder()
				.review_pk(review.getReview_pk())
				.rv_title("test123123123")
				.rv_content(review.getRv_content())
				.rv_date(LocalDateTime.now())
				.rv_star(review.getRv_star())
				.member(review.getMember())
				.movie(review.getMovie())
				.build();
		
			
			reviewRepository.save(test);
			System.out.println("review : " +  reviewRepository.findById(1L));
	}

	@Test
	public void saveTest1() throws Exception {
//		reviewService.update(1L,"testtestste", "123123123");
		Review review = reviewRepository.findById(1L).get();
		review.setRv_title("test11132");
		reviewRepository.save(review);

//			System.out.println("review : " +  reviewRepository.findById(1L));

	}
}
