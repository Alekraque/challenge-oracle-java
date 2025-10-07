package com.EasyWeather.demo.controller;

import com.EasyWeather.demo.Dto.UserCreateDTO;
import com.EasyWeather.demo.Dto.UserDTO;
import com.EasyWeather.demo.domains.User;
import com.EasyWeather.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    //post user
    @PostMapping("/api/postUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO userDTO) {
        User usuario = User.builder().build();

        usuario.setNome(userDTO.getNome());
        usuario.setEmail(userDTO.getEmail());

        User createdUser = userService.createUser(userDTO);

        UserDTO createUserDTO = UserDTO.builder()
                .id(createdUser.getId())
                .nome(createdUser.getNome())
                .email(createdUser.getEmail())
                .alertas(createdUser.getAlertas())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(createUserDTO);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
        User deletedUser = userService.deleteUser(id);

        UserDTO deletedUserDTO = UserDTO.builder()
                .id(deletedUser.getId())
                .nome(deletedUser.getNome())
                .email(deletedUser.getEmail())
                .alertas(deletedUser.getAlertas())
                .build();

        return ResponseEntity.ok(deletedUserDTO);
    }





}
