package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean isWinterMeal;

    public Meal(Long id, String name, String description, Double price, Boolean isWinterMeal) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isWinterMeal = isWinterMeal;
    }

    public Meal() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getWinterMeal() {
        return isWinterMeal;
    }

    public void setWinterMeal(Boolean winterMeal) {
        isWinterMeal = winterMeal;
    }
}
