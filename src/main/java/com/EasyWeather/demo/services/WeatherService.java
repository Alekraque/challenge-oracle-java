package com.EasyWeather.demo.services;


import com.EasyWeather.demo.domains.Weather;
import com.EasyWeather.demo.geteways.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository repository;


    public Weather save(Weather weather) {
        return repository.save(weather);
    }

    public List<Weather> findAll() {
        return repository.findAll();
    }

}
