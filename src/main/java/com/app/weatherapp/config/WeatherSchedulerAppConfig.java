package com.app.weatherapp.config;

import com.app.weatherapp.scheduler.WeatherAppScheduler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@ConditionalOnProperty(
        value = "app.scheduling.enable", havingValue = "true", matchIfMissing = true
)
@EnableScheduling
public class WeatherSchedulerAppConfig {

    @Bean
    public WeatherAppScheduler weatherAppScheduler(){
        return new WeatherAppScheduler();
    }
}
