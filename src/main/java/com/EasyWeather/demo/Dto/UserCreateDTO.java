package com.EasyWeather.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100)
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email
    @Size(max = 150)
    private String email;

    @Size(max = 100)
    private String preferenciaAcessibilidade;
}
