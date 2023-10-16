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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import zeroone.movie.member.domain.Member;
import zeroone.movie.member.repository.MemberRepository;
import zeroone.movie.member.service.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final MemberRepository memberRepository;
	
	@GetMapping(value = "/signup")
	public String createForm() {
		return "/content/members/createMemberForm";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "/content/members/login";
	}

//	마이페이지
	
//	@GetMapping("/myPage")
//	public String myPage(@SessionAttribute(name = "member", required = false) Member member, Model model) {
//		if (member == null) {
//			return "/members/login";
//		}
//		model.addAttribute("member", member);
//
//		return "content/members/myPage";
//
//	}

	// 관리자 조회
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Member> members = memberService.findAll();
		model.addAttribute("members", members);
		return "/content/members/memberList";
	}

//	// 특정 유저 삭제
//	@GetMapping("/delete")
//	public String memberDelete(Long id) {
//		memberService.delete(id);
//		return "content/members";
//	}
//
//	// 특정 유저 삭제( db 상엔 그대로 유지 )
	@GetMapping("/delete2")
	public String memberDelete2(String id) {
		memberService.deleteById(id);
		return "redirect:/list";
	}


}
