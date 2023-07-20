package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MealController {
    @Autowired
    public MealService mealService;

    @GetMapping(value = "/get/meals")
    public ResponseEntity<List<Meal>> getAllMeals() {
        return ResponseEntity.ok(mealService.getAllMeal());
    }

    @GetMapping(value = "/get/meal/{name}")
    public ResponseEntity<List<Meal>> getMealByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(mealService.getMealByName(name));
    }

    @PostMapping(value = "/post/meal")
    public ResponseEntity<Meal> postMeal(@RequestBody Meal meal) {
        mealService.insertMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @PutMapping(value = "/put/meal/{name}")
    public ResponseEntity<Meal> putMeal(@PathVariable String name, @RequestBody Meal meal) {
        mealService.updateMealByName(name, meal);
        return ResponseEntity.ok(meal);
    }

    @DeleteMapping(value = "/delete/meal/{name}")
    public ResponseEntity<Meal> deleteMealByName(@PathVariable String name) {
        Meal mealDeleted = mealService.deleteMealByName(name);
        return ResponseEntity.ok(mealDeleted);
    }

}
