package com.pen.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.pen.app.com.security.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests((requests) ->
	requests
	.antMatchers("/logout", "/login").permitAll()
	.antMatchers("/admin/**").hasAuthority("총관리자")
	
	.antMatchers("/bns/**").hasAnyAuthority("영업팀장","총관리자", "영업팀 사원")
	
	.antMatchers("/mat/matadjust", "/mat/matoptionhold").hasAnyAuthority("자재팀장","총관리자")
	.antMatchers("/mat/**").hasAnyAuthority("자재팀장", "자재팀 사원","총관리자")
	
	.antMatchers("/mak/**", "/ind/**").hasAnyAuthority("생산팀장", "생산팀 사원","총관리자")
	
	.antMatchers("/fac/equipment").hasAnyAuthority("설비팀장","총관리자")
	.antMatchers("/fac/**").hasAnyAuthority("설비팀장", "설비팀 사원","총관리자")
	
	.antMatchers("/qip/testCodeManage", "/qip/testPerItemManage").hasAnyAuthority("품질팀장","총관리자")
	.antMatchers("/qip/**").hasAnyAuthority("품질팀장", "품질팀 사원","총관리자")
	.anyRequest().authenticated())
	.formLogin(login->
		login.loginPage("/login")
		.usernameParameter("userid")
		.successHandler(successHandler())
		)
	.logout(logout->
	logout.logoutUrl("/logout")
	.logoutSuccessUrl("/top")
	);
//	.csrf().disable();
	return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/dist/**", "/plugins/**");
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		 return authenticationConfiguration.getAuthenticationManager();
	}
}
