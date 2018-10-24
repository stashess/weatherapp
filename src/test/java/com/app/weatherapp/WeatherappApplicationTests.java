package com.app.weatherapp;

import com.app.weatherapp.api.WeatherApiClient;
import org.glassfish.jersey.client.internal.HttpUrlConnector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherappApplicationTests {

    @Autowired
    ApplicationContext context;

    @Autowired
    WeatherApiClient weatherApiClient;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testApiAvaible(){
        assertEquals(HttpStatus.OK,weatherApiClient.getCurrentWeatherDataResponseEntity().getStatusCode());
    }

}
