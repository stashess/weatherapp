package com.app.weatherapp.model.dto;

import java.time.LocalDateTime;

public class WeatherDto {

    private Double temp;
    private LocalDateTime dateTime;

    public WeatherDto() {
    }

    public WeatherDto(Double temp, LocalDateTime dateTime) {
        this.temp = temp;
        this.dateTime = dateTime;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
