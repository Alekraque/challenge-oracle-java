package com.EasyWeather.demo.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "LOCALIZACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localizacao")
    private Long id;

    private Double latitude;
    private Double longitude;

    @Column(length = 100)
    private String timezone;

    @Column(name = "timezone_offset")
    private Integer timezoneOffset;

    @OneToMany(mappedBy = "localizacao", cascade = CascadeType.ALL)
    private List<Weather> climas;
}
