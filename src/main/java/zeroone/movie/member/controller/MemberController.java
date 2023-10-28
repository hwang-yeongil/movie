package zeroone.movie.member.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import zeroone.movie.member.domain.Member;
import zeroone.movie.member.dto.LoginDto;
import zeroone.movie.member.dto.MemberFormDto;
import zeroone.movie.member.dto.MyPageDto;
import zeroone.movie.member.repository.MemberRepository;
import zeroone.movie.member.service.MemberService;
import zeroone.movie.reservation.domain.Reservation;
import zeroone.movie.reservation.repository.ReservRepository;
import zeroone.movie.reservation.service.ReservService;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final ReservService reservService;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ReservRepository reservRepository;
	
	@GetMapping(value = "/signup")
	public String createForm() {
		return "content/members/createMemberForm";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "content/members/login";
	}

//	마이페이지
	
	@GetMapping("/myPage/{id}")
	public String myPage(@PathVariable String id, Model model) {
	
		MyPageDto member = memberService.findId(id);

		model.addAttribute("member", member);
//		List<Reservation> list = reservRepository.findAll();
//		model.addAttribute("reservs", list);
		List<Reservation> reservs = reservService.findMyReserv(id);
		model.addAttribute("reservs", reservs);
		return "content/members/myPage";

	}

	// 관리자 조회
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Member> members = memberService.findAll();
		model.addAttribute("members", members);
		return "content/members/memberList";
	}

//	// 특정 유저 삭제
//	@GetMapping("/delete")
//	public String memberDelete(Long id) {
//		memberService.delete(id);
//		return "content/members";
//	}
//	@GetMapping("/delete2")
//	public String memberDelete2(String id) {
//		memberService.deleteById(id);
//		return "redirect:/list";
//	}
	@GetMapping("/delete")
	public String deleteMember(String id) {
		memberService.deleteById(id);
		return "redirect:/list";
	}
	@GetMapping("/delete1")
	public String deleteMember1(String id) {
		memberService.deleteById(id);
		return "redirect:/";
	}
}
