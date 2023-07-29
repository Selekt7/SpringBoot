package com.example.springboot.service;

import com.example.springboot.model.Meal;
import com.example.springboot.repository.MealRepository;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import netscape.javascript.JSObject;
import org.json.JSONArray;
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

    public List<Meal> getWinterMeal(Double latitude, Double longitude) {
        if (-90 <= latitude && latitude<=90 && -90 <= longitude && longitude<=90) {
            Double currentTemp = getTemp(latitude, longitude);
            if (currentTemp < MAX_WINTER_TEMP) {
                return mealRepository.findByIsWinterMeal(true).get();
            }else {
                return null;
            }
        }else {
            throw new RuntimeException("latitude and longitude must be between -90 and 90");
        }
    }


    private Double getTemp(Double latitude, Double longitude) {
        try {
            JSONArray response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=" + latitude.toString() + "&longitude=" + longitude.toString() + "&hourly=temperature_2m&forecast_days=1").asJson().getBody().getObject().getJSONObject("hourly").getJSONArray("temperature_2m");
            return response.getDouble(response.length() - 1);
        } catch (UnirestException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
