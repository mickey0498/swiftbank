package com.moch.swiftbank;

import com.moch.swiftbank.Registro.Users.UsuariosRepository;
import com.moch.swiftbank.Acceso.Login;
import com.moch.swiftbank.Registro.Users.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwiftbankApplication {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private Login login;

    public static void main(String[] args) {
        SpringApplication.run(SwiftbankApplication.class, args);
    }
}