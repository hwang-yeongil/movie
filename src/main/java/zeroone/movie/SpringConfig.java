package zeroone.movie;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zeroone.movie.repository.JdbcTemplateMemberRepository;
import zeroone.movie.repository.MemberRepository;
import zeroone.movie.repository.MemoryMemberRepository;
import zeroone.movie.service.MemberService;

@Configuration
public class SpringConfig {
	
	private final DataSource dataSource;
	
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
		return new JdbcTemplateMemberRepository(dataSource);
	}
}
