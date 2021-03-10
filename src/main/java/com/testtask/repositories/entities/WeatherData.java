package com.testtask.repositories.entities;

import com.testtask.repositories.entities.enums.ApiSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "weather_data")
public class WeatherData {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "temprature")
    private int currentTemperatureInCelsius;
    @Column(name = "ait_humidity")
    private double airHumidity;
    @Column(name = "air_pressure")
    private int airPressure;
    @Column(name = "observation_time")
    private LocalTime observationTime;
    @Column(name = "description")
    private String weatherDescription;
    @Enumerated(EnumType.STRING)
    private ApiSource apiSource;
    private String city;
}
