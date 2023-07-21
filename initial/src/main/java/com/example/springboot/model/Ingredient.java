package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredienti")
public class Ingredient {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(name = "is_vegetarian")
    private Boolean isVegetarian;
    @Column(name = "is_vegan")
    private Boolean isVegan;
    @Column(name = "is_gluten_free")
    private Boolean isGlutenFree;
    @Column(name = "is_lactose_free")
    private Boolean isLactoseFree;

    public Ingredient(Long id, String name, boolean isVegetarian, boolean isVegan, boolean isGlutenFree, boolean isLactoseFree) {
        this.id = id;
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isGlutenFree = isGlutenFree;
        this.isLactoseFree = isLactoseFree;
    }

    public Ingredient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    public boolean isLactoseFree() {
        return isLactoseFree;
    }

    public void setLactoseFree(boolean lactoseFree) {
        isLactoseFree = lactoseFree;
    }
}
