package dev.elfa.auth.controller;

import dev.elfa.auth.dto.MongoUserDTO;
import dev.elfa.auth.security.MongoUserDetailsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MongoUserController {

	private final MongoUserDetailsService userDetailsService;

	@GetMapping
	public String getMe() {
		return SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getName();
	}

	@PostMapping("/login")
	public String login() {
		return SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getName();
	}

	@PostMapping("/register")
	public void register(@RequestBody MongoUserDTO newUser) {
		userDetailsService.register(newUser);
	}

	@GetMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
		SecurityContextHolder.clearContext();
	}
}
