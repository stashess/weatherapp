package com.app.weatherapp.controller;

import com.app.weatherapp.model.dto.WeatherDto;
import com.app.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Collection;

@Controller
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    //@todo add methods
    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<WeatherDto> getWeatherByData(
            @RequestParam(value = "startDate",required = false) LocalDateTime startDate,
            @RequestParam(value = "endDate",required = false) LocalDateTime endDate){

    }*/
}
