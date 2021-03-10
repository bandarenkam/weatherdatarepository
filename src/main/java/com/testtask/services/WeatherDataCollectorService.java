package com.testtask.services;

import com.testtask.repositories.entities.WeatherData;

public interface WeatherDataCollectorService {
    WeatherData getCurrentWeatherInfo(String cityName);
}
