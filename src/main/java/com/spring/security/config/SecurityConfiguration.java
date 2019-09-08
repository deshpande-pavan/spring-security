package com.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("*/hello").hasRole("ADMIN").and().httpBasic();
		http.csrf().disable();

		/*http.authorizeRequests().anyRequest().permitAll().and().addFilterBefore(customFilter(),
//			BasicAuthenticationFilter.class);*/
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("pavan").password("{noop}test").roles("USER").and().withUser("pawan")
				.password("{noop}test1").roles("ADMIN");
	}

}
