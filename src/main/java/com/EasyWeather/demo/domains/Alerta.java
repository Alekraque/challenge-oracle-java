package com.EasyWeather.demo.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "ALERT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Long id;

    @Column(name = "tipo_alerta", length = 50)
    private String tipoAlerta;

    @Column(length = 400)
    private String mensagem;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    @ManyToOne
    private User usuario;

    @ManyToOne
    private Weather weather;
}
