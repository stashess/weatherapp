package com.app.weatherapp.api;


import com.app.weatherapp.api.model.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApiClient {

    @Value("${weatherApi.url}")
    private String weatherServiceUrl;

    private RestTemplate restTemplate;

    @Autowired
    public WeatherApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<WeatherData> getCurrentWeatherDataResponseEntity(){
        return restTemplate.getForEntity(weatherServiceUrl, WeatherData.class);
    }

    public WeatherData getCurrentWeatherData(){
        return getCurrentWeatherDataResponseEntity().getBody();
    }
}
