package zeroone.movie;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/css/**","/js/**","/font/**");
	}
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().disable()                               // cors 방지
            .csrf().disable()                           // csrf 방지
            .formLogin().disable()                      // 기본 로그인 페이지 없애기
            .headers().frameOptions().disable();
        http.authorizeRequests()
	        .antMatchers("/").permitAll();
        http.formLogin()
	        .loginPage("/members/login")
	        .loginProcessingUrl("/login")
	        .defaultSuccessUrl("/")
	        .failureUrl("/members/login?error=true")
//	        .usernameParameter("username")
	        .passwordParameter("userpw")
	    .and()
	        .logout()
	        .logoutSuccessUrl("/?logout=true")
	        .invalidateHttpSession(true)
	        .deleteCookies("JSESSIONID");

		// status code 핸들링
		http.exceptionHandling().accessDeniedPage("/denied");
        return http.build();
    }
}