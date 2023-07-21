package com.example.springboot.service;

import com.example.springboot.model.Ingredient;
import com.example.springboot.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    public IngredientRepository iRepo;

    public Ingredient create(Ingredient ingredient){
        iRepo.save(ingredient);
        return ingredient;
    }
    public List<Ingredient> getAll(){
        return iRepo.findAll();
    }
    public Ingredient updateById(Long id, Ingredient i){
        Optional<Ingredient> ingredientOptional = iRepo.findById(id);
        Ingredient ingredient = null;
        if (ingredientOptional.isPresent()){
             ingredient = ingredientOptional.get();
            if (i.getName()!=null){
                ingredient.setName(i.getName());
            }
            ingredient.setGlutenFree(i.isGlutenFree());
            ingredient.setLactoseFree(i.isLactoseFree());
            ingredient.setVegan(i.isVegan());
            ingredient.setVegetarian(i.isVegetarian());
            iRepo.save(ingredient);
            return ingredient;
        }
        return ingredient;
    }
    public Ingredient deleteById(Long id){
        iRepo.deleteById(id);
        return iRepo.findById(id).get();
    }
}
