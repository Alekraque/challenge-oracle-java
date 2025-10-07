package com.EasyWeather.demo.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, length = 150)
    private String email;

    @Column(name = "preferencia_acessibilidade", length = 100)
    private String preferenciaAcessibilidade;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Alerta> alertas;
}
