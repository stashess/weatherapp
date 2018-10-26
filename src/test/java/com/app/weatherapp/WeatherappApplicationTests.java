package com.app.weatherapp;

import com.app.weatherapp.api.WeatherApiClient;
import com.app.weatherapp.config.WeatherAppConfig;
import org.glassfish.jersey.client.internal.HttpUrlConnector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = "app.scheduling.enable=false")
@SpringBootTest
public class WeatherappApplicationTests {

    @Autowired
    WeatherApiClient weatherApiClient;

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
