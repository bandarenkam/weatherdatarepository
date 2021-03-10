package com.testtask.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorldWeatherOnlineDTO {
    @JsonProperty("data.current_condition.temp_C")
    private int temp_C;
    @JsonProperty("data.current_condition.humidity")
    private double humidity;
    @JsonProperty("data.current_condition.pressure")
    private int pressure;

}
