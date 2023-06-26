package com.example.springboot;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
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
	@GetMapping(value="/greeting")
	public ResponseEntity<String> response(){

		return ResponseEntity.status(200).body("Greeting, you did a respons status");
	}


}
