package zeroone.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import zeroone.movie.service.MemberService;

public class MemberController {

	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping(value = "/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
}
