package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@RestController
public class MealController {
    private List<Meal> mealList = new ArrayList<>(
            List.of(
                    new Meal("Pasta al forno", 4.90, "Anelletti con ragù al forno"),
                    new Meal("Carbonara", 10.90, "Spaghetti con guanciale e formaggi"),
                    new Meal("Pennette primavera", 7.50, "Penne con panna, piselli e prosciutto"),
                    new Meal("Gnocchi di patate", 5.90, "Pasta di patate condita con burro"),
                    new Meal("Spaghetti col sugo", 3.90, "Spaghetti con sugo e basilico"),
                    new Meal("Linguine ai frutti di mare", 11.90, "Linguine con cozze, vongole, calamaro e pomodorino"),
                    new Meal("Farfallette al salmone", 9.90, "Farfallette con panna e salmone affmicato e prezzemolo")
            )
    );

    @GetMapping(value = "/get/meals")
    public ResponseEntity<List<Meal>> getAllMeals() {
        return ResponseEntity.ok(mealList);
    }

    @GetMapping(value = "/get/meal/{name}")
    public ResponseEntity<List<Meal>> getMealByName(@PathVariable("name") String name) {
        Meal meal = new Meal("", 0.0, "");
        List<Meal> m = mealList.stream().filter(n -> n.getName().equalsIgnoreCase(name)).toList();
        return ResponseEntity.ok(m);
    }

    @PostMapping(value = "/post/meal")
    public ResponseEntity<String> postMeal(@RequestBody Meal meal) {
        this.mealList.add(meal);
        return ResponseEntity.ok("meal added!");
    }

    @PutMapping(value = "/put/meal/{name}")
    public ResponseEntity<String> putMeal(@PathVariable String name, @RequestBody Meal meal) {
        this.mealList.removeIf(m -> m.getName().equalsIgnoreCase(name));
        this.mealList.add(meal);
        return ResponseEntity.ok("Aggiornamento effettuato!");
    }

    @DeleteMapping(value = "/delete/meal/{name}")
    public ResponseEntity<String> deleteMealByName(@PathVariable String name) {
        this.mealList.removeIf(meal -> meal.getName().equals(name));
        return ResponseEntity.ok("Pasto cancellato! :(");
    }

    @DeleteMapping(value = "/delete/meals/price/{maxPrice}")
    public ResponseEntity<String> deleteMealByPrice(@PathVariable Double maxPrice) {
        this.mealList.removeIf(meal -> meal.getPrice() >= maxPrice);
        return ResponseEntity.ok("Cancellati tutti i pasti che costano più di " + maxPrice + " euro.");
    }

    @PutMapping(value = "/put/meal/{name}/price")
    public ResponseEntity<String> updatePriceByName(@PathVariable String name, @RequestBody Double price) {
        for (Meal meal : mealList) {
            if (meal.getName().equalsIgnoreCase(name)) {
                meal.setPrice(price);
                break;
            }
        }
        return ResponseEntity.ok("Prezzo aggiornato con successo");
    }
}
