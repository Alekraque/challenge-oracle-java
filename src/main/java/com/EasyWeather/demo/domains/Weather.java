package com.EasyWeather.demo.domains;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@With
@Getter
@Entity
@Builder
@Table(name = "WEATHER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_weather")
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    private LocalDateTime sunrise;
    private LocalDateTime sunset;

    private Double temp;
    @Column(name = "feels_like")
    private Double feelsLike;
    private Integer pressure;
    private Integer humidity;
    @Column(name = "dew_point")
    private Double dewPoint;
    private Double uvi;
    private Integer clouds;
    private Integer visibility;
    @Column(name = "wind_speed")
    private Double windSpeed;
    @Column(name = "wind_deg")
    private Integer windDeg;

    @ManyToOne
    @JoinColumn(name = "id_localizacao")
    private Localizacao localizacao;

    @OneToMany(mappedBy = "weather", cascade = CascadeType.ALL)
    private List<CondicaoClimatica> condicoes;

    @OneToMany(mappedBy = "weather", cascade = CascadeType.ALL)
    private List<Alerta> alertas;

}
