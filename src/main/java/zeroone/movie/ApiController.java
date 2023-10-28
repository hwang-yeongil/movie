package zeroone.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import zeroone.movie.member.dto.LoginDto;
import zeroone.movie.member.dto.MemberFormDto;
import zeroone.movie.member.repository.MemberRepository;
import zeroone.movie.member.service.MemberService;
import zeroone.movie.movie.domain.Movie;
import zeroone.movie.movie.repository.MovieRepository;
import zeroone.movie.reservation.dto.AddReserv;
import zeroone.movie.reservation.service.ReservService;
import zeroone.movie.review.dto.AddReviewFormDto;
import zeroone.movie.review.dto.UpdateDto;
import zeroone.movie.review.service.ReviewService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

	private final MemberService memberService;
	private final ReviewService reviewService;
	private final MovieRepository movieRepository;
	private final ReservService reservService;
	@Autowired
	MemberRepository memberRepository;

	
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
//	회원 수정
	@PatchMapping("/update/{id}")
	public ResponseEntity update(@PathVariable String id, @RequestBody LoginDto loginDto) {
		ResponseEntity responseEntity = memberService.update(id, loginDto);
		return responseEntity;
	}
//	@DeleteMapping("/delete2/{id}")
//	public void memberDelete2(@PathVariable String id) {
//		System.out.println(id);
//		memberRepository.deleteById(id);
//	}
	
	
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
	
	@PatchMapping("/rvUpdate/{id}")
	public ResponseEntity update(@PathVariable Long id,@RequestBody UpdateDto updateDto) {
		ResponseEntity responseEntity = reviewService.update(id, updateDto);
		return responseEntity;
	}
	
	@PostMapping("/addReservation")
	public ResponseEntity addReservation(@RequestBody AddReserv addReserv) {
		ResponseEntity responseEntity = reservService.save(addReserv);
		return responseEntity;
	}
}
