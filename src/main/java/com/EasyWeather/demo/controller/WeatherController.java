package com.EasyWeather.demo.controller;

import com.EasyWeather.demo.Dto.WeatherDTO;
import com.EasyWeather.demo.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService service;


    @GetMapping
    public WeatherDTO getWeather(@RequestParam String city) {
        return service.getWeather(city);
    }

}

