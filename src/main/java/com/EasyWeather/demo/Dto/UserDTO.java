package com.EasyWeather.demo.Dto;

import com.EasyWeather.demo.domains.Alerta;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "O e-mail informado é inválido.")
    @Size(max = 150, message = "O e-mail pode ter no máximo 150 caracteres.")
    private String email;

    @Size(max = 100, message = "A preferência de acessibilidade pode ter no máximo 100 caracteres.")
    private String preferenciaAcessibilidade;

    private List<Alerta> alertas;

}
