package com.demo.springboot.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.demo.springboot.security.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomLoginSucessHandler sucessHandler;

	@Autowired
	private UserDetailServiceImpl userDetailService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/").permitAll().
		antMatchers("/login").permitAll().
		antMatchers("/register").permitAll().
		antMatchers("/editUser").permitAll().
		antMatchers("/admin/**").
      	hasAnyAuthority("ADMIN").
      	antMatchers("/account/**").
      	hasAnyAuthority("USER").
		anyRequest().authenticated().and().csrf().disable().
		formLogin().loginPage("/login").
		failureUrl("/login?error=true").
		successHandler(sucessHandler).
		usernameParameter("email").
		passwordParameter("password").
		and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
		logoutSuccessUrl("/login").
		and().exceptionHandling().accessDeniedPage("/access-denied");


		http.headers().frameOptions().sameOrigin();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/json/**");
	}
}
