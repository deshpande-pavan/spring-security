package com.spring.security.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloController {

	@GetMapping("/hello")
	public String hello(@AuthenticationPrincipal final UserDetails user) {
		String username = user.getUsername();
		System.out.println(username);
		Collection<? extends GrantedAuthority> authorities=user.getAuthorities();
		authorities.forEach(System.out::print);
		return "hello world!";
	}
}
