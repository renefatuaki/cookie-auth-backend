package dev.elfa.auth.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello, World!";
	}
}
