package com.app.weatherapp;

import com.app.weatherapp.controller.WeatherController;
import com.app.weatherapp.model.entity.Weather;
import com.app.weatherapp.service.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private WeatherService service;

    @Before
    public void beforeClass(){
        given(service.getWeathersBetweenDates(Mockito.any(),Mockito.any())).willReturn(Collections.singletonList(new Weather(LocalDateTime.now(),10.)));
    }

    @Test
    public void getWeatherData() throws Exception {
        mockMvc.perform(get(WeatherController.WEATHER_API + "/getWeather"
                , LocalDateTime.now(),LocalDateTime.now().plus(5,ChronoUnit.DAYS))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
