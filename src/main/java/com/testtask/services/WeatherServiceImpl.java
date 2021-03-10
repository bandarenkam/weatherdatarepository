package com.testtask.services;

import com.testtask.repositories.entities.WeatherData;
import com.testtask.repositories.repositories.WeatherDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    private WeatherDataRepository weatherDataRepository;

    public WeatherServiceImpl(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<WeatherData> findAll() {
        return weatherDataRepository.findAll();
    }

    @Override
    @Transactional
    public void save(List<WeatherData> newWeatherDataList) {
        weatherDataRepository.saveAll(newWeatherDataList);
    }
}
