package com.moch.swiftbank.Registro.Password;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Seguridad implements SeguridadI {

    @Bean
    @Override
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCryptPasswordEncoder
    }
}

// BCrypt.gensalt() generates a string representing the salt,
// but the BCryptPasswordEncoder constructor expects an integer for the strength parameter