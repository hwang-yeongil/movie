package zeroone.movie;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import zeroone.movie.repository.JpaMemberRepository;
import zeroone.movie.repository.MemberRepository;

import zeroone.movie.service.MemberService;

@Configuration
public class SpringConfig {

//	private final DataSource dataSource;
//	private final EntityManager em;
	private final MemberRepository memberRepository;

	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
//		this.dataSource = dataSource;
//		this.em = em;
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

}
