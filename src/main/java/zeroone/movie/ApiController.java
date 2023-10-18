package zeroone.movie;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import zeroone.movie.member.dto.LoginDto;
import zeroone.movie.member.dto.MemberFormDto;
import zeroone.movie.member.service.MemberService;
import zeroone.movie.movie.domain.Movie;
import zeroone.movie.movie.repository.MovieRepository;
import zeroone.movie.review.dto.AddReviewFormDto;
import zeroone.movie.review.service.ReviewService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

	private final MemberService memberService;
	private final ReviewService reviewService;
	private final MovieRepository movieRepository;
	

	
//	회원가입
	@PostMapping("/signup")
	public ResponseEntity userSignup(@RequestBody MemberFormDto formDto) {
		return memberService.signup(formDto);
	}
//	로그인
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginDto loginDto) {
		return memberService.login(loginDto);
	}
//	리뷰 작성
	@PostMapping("/addReview")
	public ResponseEntity save(@RequestBody AddReviewFormDto formDto) {
		ResponseEntity responseEntity = reviewService.save(formDto);
		return responseEntity;
	}
	@DeleteMapping("/reviewList/{id}")
	public ResponseEntity remove(@PathVariable Long id) {
		ResponseEntity responseEntity = reviewService.remove(id);
		return responseEntity;
	}
//	삭제가 되긴한데 뭔가 문제가 있음 확인 요망
}
