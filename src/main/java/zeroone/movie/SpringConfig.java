package zeroone.movie;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zeroone.movie.repository.JdbcTemplateMemberRepository;
import zeroone.movie.repository.JpaMemberRepository;
import zeroone.movie.repository.MemberRepository;
import zeroone.movie.repository.MemoryMemberRepository;
import zeroone.movie.service.MemberService;

@Configuration
public class SpringConfig {

	private final DataSource dataSource;
//	private final EntityManager em;
//	private final MemberRepository memberRepository;

	@Autowired
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
//		this.em = em;
//		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
//	    return new MemoryMemberRepository();
//	    return new JdbcMemberRepository(dataSource);
		return new JdbcTemplateMemberRepository(dataSource);
	}
}
