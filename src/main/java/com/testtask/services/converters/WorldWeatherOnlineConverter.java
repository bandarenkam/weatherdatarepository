package com.testtask.services.converters;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.testtask.repositories.entities.WeatherData;
import com.testtask.repositories.entities.enums.ApiSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class WorldWeatherOnlineConverter implements Converter<ObjectNode, WeatherData> {
    @Override
    public WeatherData convert(ObjectNode jsonNodes) {
       return  WeatherData.builder()
                .currentTemperatureInCelsius(jsonNodes.at("/data/current_condition/0/temp_C").asInt())
                .airHumidity(jsonNodes.at("/data/current_condition/0/humidity").asDouble())
                .airPressure(jsonNodes.at("/data/current_condition/0/pressure").asInt())
                .weatherDescription(jsonNodes.at("/data/current_condition/0/weatherDesc/0/value").asText())
                .observationTime(LocalTime.parse(jsonNodes.at("/data/current_condition/0/observation_time").asText(),
                        DateTimeFormatter.ofPattern("h:m a")))
                .apiSource(ApiSource.WORLD_WEATHER_ONLINE)
                .build();

    }
}
