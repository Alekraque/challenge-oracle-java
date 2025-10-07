package com.EasyWeather.demo.geteways;

import com.EasyWeather.demo.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
