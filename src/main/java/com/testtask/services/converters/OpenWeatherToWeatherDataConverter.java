package com.testtask.services.converters;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.testtask.repositories.entities.WeatherData;
import com.testtask.repositories.entities.enums.ApiSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;


@Component
public class OpenWeatherToWeatherDataConverter implements Converter<ObjectNode, WeatherData> {
    @Override
    public WeatherData convert(ObjectNode objectNode) {
        return  WeatherData.builder()
                //calvin to celsius
                .currentTemperatureInCelsius((int) Math.round(objectNode.at("/main/temp").asDouble() - 273.15) )
                .airHumidity(objectNode.at("/main/humidity").asDouble())
                .airPressure(objectNode.at("/main/pressure").asInt())
                .weatherDescription(objectNode.at("/weather/0/description").asText())
                //has no info about this field
                .observationTime(LocalTime.now())
                .apiSource(ApiSource.OPEN_WEATHER_MAP)
                .build();
    }
}
