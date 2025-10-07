package com.EasyWeather.demo.services;

import com.EasyWeather.demo.Dto.UserCreateDTO;
import com.EasyWeather.demo.Dto.UserDTO;
import com.EasyWeather.demo.domains.User;
import com.EasyWeather.demo.geteways.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    //post
    public User createUser(UserCreateDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Já existe um usuário com este e-mail.");
        }

        User usuario = User.builder().build();
        usuario.setNome(userDTO.getNome());
        usuario.setEmail(userDTO.getEmail());

        User savedUser = userRepository.save(usuario);


        UserDTO userDTO1 = UserDTO.builder()
                .id(savedUser.getId())
                .nome(savedUser.getNome())
                .email(savedUser.getEmail())
                .build();

        return userRepository.save(savedUser);
    }

    //delete
    public User deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        userRepository.deleteById(id);
        return user;
    }
}
