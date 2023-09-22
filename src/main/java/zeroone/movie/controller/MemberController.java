package zeroone.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import zeroone.movie.domain.Member;
import zeroone.movie.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping(value = "/members/new")
	public String createForm() {
		return "content/members/createMemberForm";
	}
	
	// 회원 등록
	@PostMapping(value = "/members/new")
	public String create(MemberForm form) {
		
		Member member = new Member();
//		member.setId(2L);
		member.setName(form.getName());
		member.setUserpw(form.getUserpw());
		member.setAddress(form.getAddress());
		
		memberService.join(member);
		
		return "redirect:/";
	}
	
	//조회
	@GetMapping(value = "/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "content/members/memberList";
	}
}
