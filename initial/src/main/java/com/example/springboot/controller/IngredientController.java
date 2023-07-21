package com.example.springboot.controller;

import com.example.springboot.model.Ingredient;
import com.example.springboot.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    public IngredientService ingredientService;

    @GetMapping("/get")
    public ResponseEntity<List<Ingredient>> getAllIngredient(){
        return ResponseEntity.ok().body(ingredientService.getAll());
    }
    @PostMapping("/post")
    public ResponseEntity<Ingredient> postIngredient(@RequestBody Ingredient ingredient){
        return ResponseEntity.ok().body(ingredientService.create(ingredient));
    }
    @PutMapping("/put")
    public ResponseEntity<Ingredient> updateById(@RequestBody Ingredient ingredient,@RequestParam Long id){
        return ResponseEntity.ok().body(ingredientService.updateById(id, ingredient));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Ingredient> deleteById(@RequestParam Long id){
        return ResponseEntity.ok().body(ingredientService.deleteById(id));
    }
}
