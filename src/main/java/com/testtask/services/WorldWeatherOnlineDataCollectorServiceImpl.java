package com.testtask.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.testtask.repositories.entities.WeatherData;
import com.testtask.services.converters.WorldWeatherOnlineConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class WorldWeatherOnlineDataCollectorServiceImpl implements WeatherDataCollectorService {
    private String WORLD_WEATHER_KEY = "b0a0ef42fef14d6ca53125712210903";
    private String URL_TEMPLATE =  "https://api.worldweatheronline.com/premium/v1/weather.ashx?q=%s&key=%s&format=json";
    private RestTemplate restTemplate;
    private WorldWeatherOnlineConverter converter;

    @Autowired
    public WorldWeatherOnlineDataCollectorServiceImpl(RestTemplate restTemplate, WorldWeatherOnlineConverter converter) {
        this.restTemplate = restTemplate;
        this.converter = converter;
    }

    @Override
    public WeatherData getCurrentWeatherInfo(String cityName) {
        ObjectNode weatherObjectNode =
                restTemplate.getForObject(String.format(URL_TEMPLATE, cityName, WORLD_WEATHER_KEY), ObjectNode.class);
        WeatherData weatherData = converter.convert(weatherObjectNode);
        weatherData.setCity(cityName);
        return weatherData;
    }
}
