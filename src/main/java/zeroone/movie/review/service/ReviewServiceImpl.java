package zeroone.movie.review.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

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
import zeroone.movie.review.repository.ReviewRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
	
	private final MemberRepository memberRepository;
	private final ReviewRepository reviewRepository;
	private final MovieRepository movieRepository;
	private final EntityManager em;
	
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
	
	@Override
	public List<Review> findListbyid(Long id) {
		// TODO Auto-generated method stub
		return em.createQuery("select r from Review r where r.movie_pk = :id")
			.setParameter("id", id)
			.getResultList();
		
	}
}
