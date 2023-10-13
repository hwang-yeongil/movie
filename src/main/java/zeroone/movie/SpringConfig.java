package zeroone.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zeroone.movie.member.repository.MemberRepository;
import zeroone.movie.member.service.MemberService;

@Configuration
//@EnableWebSecurity
public class SpringConfig {

	private final MemberRepository memberRepository;

	@Autowired
	public SpringConfig(MemberRepository memberRepository) {

		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.ignoring().antMatchers("/css/**","/js/**","/font/**");
//	}
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
//		http.cors().disable()
//			.csrf().disable()
//			.headers().frameOptions().disable();
//		http.formLogin()
//		.loginPage("/members/login.html")
//		.loginProcessingUrl("/login")
//		.usernameParameter("username")
//		.passwordParameter("userpw")
//		.failureUrl("/members/login?error=true")
//
//		.defaultSuccessUrl("/members/myPage");
//		http.formLogin()
//			.loginPage("/content/members/login")
//			.loginProcessingUrl("/login")
//			.defaultSuccessUrl("content/members/myPage")
//			.failureUrl("/login?error=true")
//			.usernameParameter("username")
//			.passwordParameter("userpw")
//			.and()
//			.logout()
//			.logoutSuccessUrl("/?logout=true")
//            .invalidateHttpSession(true)
//            .deleteCookies("JSESSIONID");
//		
//		http.exceptionHandling().accessDeniedPage("/denied");
//		
//		 return http.build();
//	}
	
}
