package com.lms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lms.api.service.MyUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthProvider());
		
		/*auth.inMemoryAuthentication()
			.withUser("harry").password(getPassEncoder().encode("potter")).authorities("HR");
		auth.inMemoryAuthentication()
			.withUser("ron").password(getPassEncoder().encode("weasly")).authorities("ADMIN");*/
	}
	
	private AuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(myUserDetailsService);
		auth.setPasswordEncoder(getPassEncoder());
		return auth;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/user/register").permitAll()
			.antMatchers(HttpMethod.GET,"/user/login").authenticated()
			.antMatchers(HttpMethod.PUT, "/user/update/{id}").authenticated()
			.antMatchers(HttpMethod.POST, "/learningtrack").authenticated()
			.antMatchers(HttpMethod.POST, "/course/{ltid}").authenticated()
			.antMatchers(HttpMethod.GET, "/learning-track").authenticated()
			.antMatchers(HttpMethod.POST, "/enroll/user/learning_track/{uid}/{lid}").authenticated()
			.antMatchers(HttpMethod.GET, "/user/learningtrack").authenticated()
			.antMatchers(HttpMethod.POST, "/author").authenticated()
			.antMatchers(HttpMethod.GET, "/course").authenticated()
			.antMatchers(HttpMethod.POST, "/course/author/{cid}/{aid}").authenticated()
			.antMatchers(HttpMethod.DELETE, "/course/author/{cid}/{aid}").authenticated()
			.antMatchers(HttpMethod.POST, "/review/{cid}").authenticated()
			.antMatchers(HttpMethod.GET, "/review/{cid}").authenticated()
			.antMatchers(HttpMethod.GET, "/reviewsorted/{cid}").authenticated()
			.antMatchers(HttpMethod.PUT, "/review/{rid}").authenticated()
			.antMatchers(HttpMethod.GET, "/reviewstats/{cid}").authenticated()
			.antMatchers(HttpMethod.GET, "/reviews").authenticated()
			.antMatchers(HttpMethod.GET, "/review-all-info/{cid}").authenticated()
			.antMatchers(HttpMethod.POST, "/module/{cid}").authenticated()
			.antMatchers(HttpMethod.POST, "/video/{mid}").authenticated()
			.antMatchers(HttpMethod.GET, "/module/{cid}").authenticated()
			.antMatchers(HttpMethod.GET, "/module/alternate/{cid}").authenticated()
			.antMatchers(HttpMethod.GET, "/course/video/stats/{cid}").authenticated()
			.antMatchers(HttpMethod.POST, "/forum").authenticated()
			.antMatchers(HttpMethod.GET, "/forum").authenticated()
			.antMatchers(HttpMethod.POST, "/question").authenticated()
			.antMatchers(HttpMethod.GET, "/question").authenticated()
			.antMatchers(HttpMethod.POST, "/answer").authenticated()
			.antMatchers(HttpMethod.GET, "/answer").authenticated()
			.antMatchers(HttpMethod.POST, "/forum/question/{fid}/{qid}").authenticated()
			.antMatchers(HttpMethod.POST, "/question/answer/{qid}/{aid}").authenticated()
			.antMatchers(HttpMethod.GET, "/question/{fid}").authenticated()
			.antMatchers(HttpMethod.GET, "/answer/{qid}").authenticated()
			.antMatchers(HttpMethod.PUT, "/answer/updatelike/{aid}").authenticated()
			.antMatchers(HttpMethod.PUT, "/question/updatelike/{qid}").authenticated()
			.antMatchers(HttpMethod.PUT, "/answer/{aid}").authenticated()
			.antMatchers(HttpMethod.PUT, "/question/{qid}").authenticated()
			.antMatchers(HttpMethod.GET, "/forum/stats").authenticated()
			.and()
			.httpBasic().and().csrf().disable();
	}
	
	@Bean
	public PasswordEncoder getPassEncoder() {
		PasswordEncoder passEncoder = new BCryptPasswordEncoder();
		return passEncoder;
	}
}
