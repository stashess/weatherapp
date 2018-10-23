package com.app.weatherapp.config;

import com.app.weatherapp.scheduler.WeatherAppScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class WeatherAppConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public WeatherAppScheduler weatherAppScheduler(){
        return new WeatherAppScheduler();
    }
}
