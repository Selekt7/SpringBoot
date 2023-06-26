package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class newController {
    @GetMapping(value="/info")
    public ResponseEntity<String> response (){
        return ResponseEntity.status(200).body("200 OK");
    }
}
