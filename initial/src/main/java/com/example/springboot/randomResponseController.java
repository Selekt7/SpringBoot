package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class randomResponseController {
    @GetMapping(value = "/random")
    public ResponseEntity<?> response() {
        Random random = new Random();
        boolean b = random.nextBoolean();
        if (b) {
            return ResponseEntity.status(200).body("The random was TRUE!");
        } else {
            return ResponseEntity.status(400).body("The random was FALSE!");
        }
    }
}
