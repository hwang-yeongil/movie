package zeroone.movie.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import zeroone.movie.member.dto.LoginDto;
import zeroone.movie.member.dto.MemberFormDto;
import zeroone.movie.member.service.MemberService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

	private final MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity userSignup(@RequestBody MemberFormDto formDto) {
		return memberService.signup(formDto);
	}

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginDto loginDto) {
		return memberService.login(loginDto);
	}
}
