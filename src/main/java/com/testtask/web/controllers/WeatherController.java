package com.testtask.web.controllers;

import com.testtask.repositories.entities.WeatherData;
import com.testtask.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @ResponseBody
    @CrossOrigin
    @GetMapping(value = "/weatherData", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WeatherData> getAll() {
       return weatherService.findAll();
    }
}
