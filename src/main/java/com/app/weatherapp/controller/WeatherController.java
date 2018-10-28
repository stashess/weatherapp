package com.app.weatherapp.controller;

import com.app.weatherapp.model.dto.WeatherDto;
import com.app.weatherapp.model.util.WeatherUtil;
import com.app.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;

import static com.app.weatherapp.controller.WeatherController.WEATHER_API;
import static org.springframework.format.annotation.DateTimeFormat.*;

@RestController
@RequestMapping(WEATHER_API)
public class WeatherController {

    public static final String WEATHER_API = "/api/weather";

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/getWeather", method = RequestMethod.GET)
    @CrossOrigin
    public Collection<WeatherDto> getWeatherByData(
            @RequestParam(value = "startDate")
            @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate")
            @DateTimeFormat(iso = ISO.DATE_TIME)LocalDateTime endDate) {
        return WeatherUtil.getWeatherDto(weatherService.getWeathersBetweenDates(startDate, endDate));
    }
}
