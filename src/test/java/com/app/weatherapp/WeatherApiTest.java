package com.app.weatherapp;

import com.app.weatherapp.api.WeatherApiClient;
import com.app.weatherapp.config.WeatherAppConfig;
import com.app.weatherapp.controller.WeatherController;
import com.app.weatherapp.model.dto.WeatherDto;
import org.glassfish.jersey.client.internal.HttpUrlConnector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Collection;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = "app.scheduling.enable=false")
@SpringBootTest
public class WeatherApiTest {

    @Autowired
    WeatherApiClient weatherApiClient;

    @Autowired
    WeatherController weatherController;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetCurrentWeather(){
        assertEquals(HttpStatus.OK,weatherApiClient.getCurrentWeatherDataResponseEntity().getStatusCode());
    }

    @Test
    public void testGetWeatherForecast(){
        assertEquals(HttpStatus.OK,weatherApiClient.getForecastResponseEntity().getStatusCode());
    }

}
