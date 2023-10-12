package zeroone.movie.member.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

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
		member.setUsername(form.getName());
		member.setUserpw(form.getUserpw());
		// 초기값 0으로 > 1일때 (관리자 / 삭제된 계정)
		member.setAdmin(0);
		member.setSecession(0);

		memberService.join(member);

		return "redirect:/members";
	}

	// 로그인
	@GetMapping(value = "/members/login")
	public String login(Model model) {
		model.addAttribute("member", new Member());
		return "content/members/login";
	}

	@PostMapping(value = "/members/login")
	public String login(@ModelAttribute Member member, HttpServletRequest request) throws Exception {
		if (memberService.login(member.getUsername(), member.getUserpw())) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);

		} else {
			return "../login";
		}
		return "../myPage";
	}

//	마이페이지
	@GetMapping("/members/myPage")
	public String myPage(@SessionAttribute(name = "member", required = false) Member member, Model model) {
		if (member == null) {
			return "/members/login";
		}
		model.addAttribute("member", member);

		return "content/members/myPage";

	}

	// 관리자 조회
	@GetMapping(value = "/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "content/members/memberList";
	}

	// 특정 유저 삭제
	@GetMapping("/member/delete")
	public String memberDelete(Long id) {
		memberService.delete(id);
		return "content/members";
	}

	// 특정 유저 삭제( db 상엔 그대로 유지 )
	@GetMapping("/member/delete2")
	public String memberDelete2(Long id) {
		memberService.deleteId(id);
		return "redirect:/members";
	}

	@GetMapping("/home")
	public String home() {
		return "content/home";
	}

}
