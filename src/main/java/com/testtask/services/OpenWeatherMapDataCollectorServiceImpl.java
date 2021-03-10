package com.testtask.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.testtask.repositories.entities.WeatherData;
import com.testtask.services.converters.OpenWeatherToWeatherDataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapDataCollectorServiceImpl implements WeatherDataCollectorService {
    private RestTemplate restTemplate;
    private OpenWeatherToWeatherDataConverter openWeatherToWeatherDataConverter;
    private final String OPEN_WEATHER_MAP_KEY = "f948849c9e6c09a26495629d963a637a";
    private final String OPEN_WEATHER_URL_TEMPLATE = "http://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s";

    @Autowired
    public OpenWeatherMapDataCollectorServiceImpl(RestTemplate restTemplate,
                                                  OpenWeatherToWeatherDataConverter openWeatherToWeatherDataConverter) {
       this.restTemplate = restTemplate;
       this.openWeatherToWeatherDataConverter = openWeatherToWeatherDataConverter;
    }

    @Override
    public WeatherData getCurrentWeatherInfo(String cityName) {
        ObjectNode objectNode =
                restTemplate.getForObject(String.format(OPEN_WEATHER_URL_TEMPLATE, cityName, OPEN_WEATHER_MAP_KEY), ObjectNode.class);
        WeatherData weatherData = openWeatherToWeatherDataConverter.convert(objectNode);
        weatherData.setCity(cityName);
        return weatherData;
    }
}
