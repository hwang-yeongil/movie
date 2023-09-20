package zeroone.movie.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import zeroone.movie.domain.Member;
import zeroone.movie.repository.MemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	@Test
	public void 회원가입() throws Exception{
		Member member = new Member();
		member.setName("hello");
		member.setId(10L);
//		System.out.println(member.getName());
		
		memberService.join(member);
		
//		Long saveId = memberService.join(member);
		
		Member findMember = memberRepository.findById(memberService.join(member)).get();
		assertEquals(member.getName(), findMember.getName());
	}
	
	@Test
    public void 중복_회원_예외() throws Exception {
        // Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1); 
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
      
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
