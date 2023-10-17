//package zeroone.movie.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import zeroone.movie.member.domain.Member;
//import zeroone.movie.member.repository.MemberRepository;
//import zeroone.movie.member.service.MemberService;
//
//@SpringBootTest
//@Transactional
//public class MemberServiceIntegrationTest {
//
//	@Autowired
//	MemberService memberService;
//	@Autowired
//	MemberRepository memberRepository;
//
////	@Test
//	public void 회원가입() throws Exception {
//		Member member = new Member();
//		member.setUsername("hello111");
//		member.setUserpw("hello");
////		member.setId(10L);
////		System.out.println(member.getName());
//
////		memberService.join(member);
//
//		Long saveId = memberService.join(member);
//
//		Member findMember = memberRepository.findById(saveId).get();
//		assertEquals(member.getUsername(), findMember.getUsername());
//	}
//
//	
////	@Test
//	public void 중복_회원_예외() throws Exception {
//		// Given
//		Member member1 = new Member();
//		member1.setUsername("spring");
//
//		Member member2 = new Member();
//		member2.setUsername("spring");
//
//		// when
//		memberService.join(member1);
//		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//
//		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//	}
//
////	@Test
//	public void 수정() throws Exception {
//		memberService.update(1L, "update", "update");
//
//	}
//
////    @Test
//	public void 회원삭제() throws Exception {
//		memberRepository.deleteById((long) 29);
//
//	}
//	
//	@Test
//	public void 로그인() throws Exception {
//		System.out.println(memberService.login("tester1", "1234"));
//	}
//	@Test
//	public void 회원정보찾기() throws Exception {
////		System.out.println(memberRepository.findByName("tester1").get());
//		
//		System.out.println(memberRepository.findByUsername("tester1").get().getId());
//		System.out.println(memberRepository.findByUsername("tester1").get().getUsername());
//		System.out.println(memberRepository.findByUsername("tester1").get().getUserpw());
//		
//	}
//}
