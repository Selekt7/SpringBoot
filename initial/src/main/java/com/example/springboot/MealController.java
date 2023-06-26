package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MealController {
    private List<Meal> mealList = new ArrayList<>(List.of(
            new Meal("Pasta al forno", 4.90),
            new Meal("Carbonara", 10.90),
            new Meal("Pennette primavera", 7.50),
            new Meal("Gnocchi di patate", 5.90),
            new Meal("Spaghetti col sugo", 3.90),
            new Meal("Linguine ai frutti di mare", 11.90),
            new Meal("Farfallette al salmone", 9.90)
    ));

//    @GetMapping(value = "/meals")
//    public ResponseEntity<List<Meal>> response() {
//        return ResponseEntity.ok(mealList);
//    }


    @GetMapping(value = "/meals/{name}")
    public ResponseEntity<Meal> getByName(@PathVariable("name") String name) {
        Meal m = new Meal("", 0.0);
        List<Meal> theMeal= mealList.stream().filter(n->n.getName().equalsIgnoreCase(name)).toList();
        m.setName(theMeal.get(0).getName());
        m.setPrice(theMeal.get(0).getPrice());
        return ResponseEntity.ok(m);
    }

}
