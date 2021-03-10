package com.testtask.services;

import com.testtask.repositories.entities.WeatherData;

import java.util.List;

public interface WeatherService {
    List<WeatherData> findAll();
    void save(List<WeatherData> newWeatherDataList);
}
