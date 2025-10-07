package com.EasyWeather.demo.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CONDICTION_WEATHER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CondicaoClimatica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicao")
    private Long id;

    @Column(length = 80)
    private String main;

    @Column(length = 200)
    private String description;

    @Column(length = 10)
    private String icon;

    @ManyToOne
    @JoinColumn(name = "id_weather")
    private Weather weather;
}
