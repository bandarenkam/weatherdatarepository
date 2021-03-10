package com.testtask.services.scheduling;

import com.testtask.repositories.entities.WeatherData;
import com.testtask.services.WeatherDataCollectorService;
import com.testtask.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherDataRequesterJob {
    private List<WeatherDataCollectorService> weatherDataCollectorServices;
    private WeatherService weatherService;
    private List<String> cities = new ArrayList<>();

    {
        cities.add("Moscow");
        cities.add("Minsk");
        cities.add("Paris");
    }

    @Autowired
    public WeatherDataRequesterJob(List<WeatherDataCollectorService> weatherDataCollectorService,
                                   WeatherService weatherService) {
        this.weatherDataCollectorServices = weatherDataCollectorService;
        this.weatherService = weatherService;
    }

    //hardcoded every 5 minutes schedule
    @Scheduled(fixedRate = 5 * 60 * 1000)
    public void requestForCurrentWeatherDataAndSave() {
        List<WeatherData> weatherDataForSaving = new ArrayList<>();

        weatherDataCollectorServices.forEach(
                weatherDataCollectorService ->  {
                    cities.forEach( city -> {
                        WeatherData weatherData = weatherDataCollectorService.getCurrentWeatherInfo(city);
                        weatherDataForSaving.add(weatherData);
                    });
                }
        );

        weatherService.save(weatherDataForSaving);
    }
}
