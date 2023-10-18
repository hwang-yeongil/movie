package zeroone.movie.review.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import zeroone.movie.member.domain.Member;
import zeroone.movie.member.repository.MemberRepository;
import zeroone.movie.movie.domain.Movie;
import zeroone.movie.movie.repository.MovieRepository;
import zeroone.movie.review.domain.Review;
import zeroone.movie.review.dto.AddReviewFormDto;
import zeroone.movie.review.dto.DetailDto;
import zeroone.movie.review.dto.ReviewListDto;
import zeroone.movie.review.repository.ReviewRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
	
	private final MemberRepository memberRepository;
//	private final ReviewRepository reviewRepository;
	private final MovieRepository movieRepository;
	private final EntityManager em;
	@Autowired
	ReviewRepository reviewRepository;
	
// 리뷰 저장	
	@Override
	public ResponseEntity save(AddReviewFormDto formDto) {
		// TODO Auto-generated method stub
		Optional<Member> member = memberRepository.findById(formDto.getMember_id());
		Optional<Movie> movie = movieRepository.findById(formDto.getMovie_pk());
		
		if(member.isPresent()) {
			Member memberEntity = member.get();
			Movie movieEntity = movie.get();
			
			Review review = Review.builder()
				.rv_title(formDto.getRv_title())
				.rv_content(formDto.getRv_content())
				.rv_date(LocalDateTime.now())
				.rv_star(formDto.getRv_star())
				.member(memberEntity)
				.movie(movieEntity)
				.build();
			
			reviewRepository.save(review);
			 
			return new ResponseEntity("success", HttpStatus.OK);
		}else {
			return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
		}
	}
// 리뷰 전체 ( 관리자 용
	@Override
	public List<ReviewListDto> getAll() {
		// TODO Auto-generated method stub
		List<Review> reviews = reviewRepository.findAll();
		List<ReviewListDto> list = new ArrayList<>();
		
		for(Review review : reviews) {
			Member member = review.getMember();
			Movie movie = review.getMovie();
			
			ReviewListDto dto = ReviewListDto.builder()
					.review_pk(review.getReview_pk())
					.rv_title(review.getRv_title())
					.rv_date(review.getRv_date())
					.rv_star(review.getRv_star())
					.member(member)
					.movie(movie)
					.build();
			
			list.add(dto);
		}
		return list;
	}
	
//	리뷰 페이지 ( 영화별 구분
	@Override
	public List<ReviewListDto> getAllPk(Long id) {
		// TODO Auto-generated method stub
		List<Review> reviews = reviewRepository.findAll();
		List<ReviewListDto> list = new ArrayList<>();
		
		for(Review review : reviews) {
			if(review.getMovie().getMovie_pk().equals(id)) {
				
				Member member = review.getMember();
				Movie movie = review.getMovie();
				
				ReviewListDto dto = ReviewListDto.builder()
						.review_pk(review.getReview_pk())
						.rv_title(review.getRv_title())
						.rv_date(review.getRv_date())
						.rv_star(review.getRv_star())
						.member(member)
						.movie(movie)
						.build();
				
				list.add(dto);
			}
		}
		return list;
	}
	
//	리뷰 
	@Override
	public DetailDto getDetail(Long id) {
		// TODO Auto-generated method stub
		Optional<Review> review = reviewRepository.findById(id);
		Review reviewEntity = review.orElse(null);
		
		Member member = reviewEntity.getMember();
		Movie movie = reviewEntity.getMovie();

		DetailDto dto = DetailDto.builder()
				.review_pk(reviewEntity.getReview_pk())
				.rv_title(reviewEntity.getRv_title())
				.rv_content(reviewEntity.getRv_content())
				.rv_date(reviewEntity.getRv_date())
				.rv_star(reviewEntity.getRv_star())
				.member_id(member.getId())
				.movie(movie)
				.build();
		
		return dto;
	}
	
	@Override
	public ResponseEntity remove(Long id) {
		// TODO Auto-generated method stub
		reviewRepository.deleteById(id);
		return new ResponseEntity("success", HttpStatus.OK);
	}
}
