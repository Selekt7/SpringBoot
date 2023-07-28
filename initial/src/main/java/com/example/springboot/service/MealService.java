package com.example.springboot.service;

import com.example.springboot.model.Meal;
import com.example.springboot.repository.MealRepository;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;

import com.mashape.unirest.http.HttpResponse;

import java.util.List;

@Service
public class MealService {
    @Autowired
    public MealRepository mealRepository;

    private Double MAX_WINTER_TEMP = 18.0;

    public List<Meal> getWinterMeal() {
        Double currentTemp = getTemp();
        if (currentTemp < MAX_WINTER_TEMP) {
            return mealRepository.findByIsWinterMeal(true).get();
        } else {
            return null;
        }
    }


    private Double getTemp() {
        try {
            //non sono riuscito a trovare il link contenente il json corretto, o forse, il sito ha cambiato la risposta
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=59.9127&longitude=10.7461&hourly=temperature_2m,weathercode").asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
