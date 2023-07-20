package com.example.springboot.service;

import com.example.springboot.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {
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

    public Meal insertMeal(Meal meal) {
        this.mealList.add(meal);
        return meal;
    }

    public List<Meal> getMealByName(String name) {
        List<Meal> m = mealList.stream().filter(n -> n.getName().equalsIgnoreCase(name)).toList();
        return m;
    }

    public List<Meal> getAllMeal() {
        return mealList;
    }

    public void updateMealByName(String name, Meal meal) {
        this.mealList.removeIf(m -> m.getName().equalsIgnoreCase(name));
        this.mealList.add(meal);
    }

    public Meal deleteMealByName(String name) {
        Optional<Meal> mealDeleted = this.mealList.stream().filter(meal -> meal.getName().equalsIgnoreCase(name)).findFirst();
        if (mealDeleted.isPresent()) {
            this.mealList.remove(mealDeleted.get());
        }
        return mealDeleted.get();

    }


}

