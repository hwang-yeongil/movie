package zeroone.movie.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import zeroone.movie.member.domain.Member;
import zeroone.movie.member.repository.MemberRepository;
import zeroone.movie.member.service.MemberService;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	public void 삭제() throws Exception {
		memberService.deleteById("1234");
	}

}
