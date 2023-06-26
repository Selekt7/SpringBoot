package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value="/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	@GetMapping(value="/hello")
	public String index1() {
		return "Hello World";
	}

}
