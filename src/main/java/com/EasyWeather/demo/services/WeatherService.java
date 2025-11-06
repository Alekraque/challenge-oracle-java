package com.EasyWeather.demo.services;


import com.EasyWeather.demo.Dto.WeatherDTO;
import com.EasyWeather.demo.domains.Weather;
import com.EasyWeather.demo.geteways.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class WeatherService {
    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final WeatherRepository repository;


    public WeatherDTO getWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&lang=pt_br&units=metric";

        return restTemplate.getForObject(url, WeatherDTO.class);
    }

    public List<Weather> findAll() {
        return repository.findAll();
    }

}
