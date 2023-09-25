package zeroone.movie.member.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import zeroone.movie.member.domain.Member;
import zeroone.movie.member.repository.MemberRepository;
import zeroone.movie.member.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberService;
	private final MemberRepository memberRepository;

	@Autowired
	public MemberController(MemberService memberService, MemberRepository memberRepository) {
		this.memberService = memberService;
		this.memberRepository = memberRepository;
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
//		초기값 0으로 > 1일때 (관리자 / 삭제된 계정)
		member.setAdmin(0);
		member.setSecession(0);

		memberService.join(member);

		return "redirect:/";
	}

	@GetMapping(value = "/members/login")
	public String login() {
		return "content/members/login";
	}

	@PostMapping(value = "/members/login")
	public String login(@RequestParam String username, @RequestParam String userpw) {
		if (memberService.login(username, userpw)) {
			return "content/members/memberList";
		}
		return "content/members/login";
	}

	// 조회
	@GetMapping(value = "/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "content/members/memberList";
	}

	// 특정 게시물 삭제
	@GetMapping("/member/delete")
	public String memberDelete(Long id) {
		memberService.delete(id);
		return "redirect:/members";
	}

	@GetMapping("/member/delete2")
	public String memberDelete2(Long id) {
		memberService.deleteId(id);
		return "redirect:/members";
	}
}
