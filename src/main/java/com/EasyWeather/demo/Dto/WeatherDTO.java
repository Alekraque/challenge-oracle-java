package com.EasyWeather.demo.Dto;

import lombok.Data;

import java.util.List;

    @Data
    public class WeatherDTO {
        private Main main;
        private Wind wind;
        private List<WeatherDescription> weather;
        private String name; // nome da cidade


        @Data
        public static class Main {
            private Double temp;
            private Integer humidity;
            private Double feels_like;
            private Integer pressure;
        }

        @Data
        public static class Wind {
            private Double speed;
            private Integer deg;
        }

        @Data
        public static class WeatherDescription {
            private String main;
            private String description;
        }
    }
