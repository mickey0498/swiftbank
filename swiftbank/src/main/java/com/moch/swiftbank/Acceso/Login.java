package com.moch.swiftbank.Acceso;

import com.moch.swiftbank.Registro.Users.Usuarios;
import com.moch.swiftbank.Registro.Users.UsuariosRepository;
import com.moch.swiftbank.Registro.Users.UsuariosService;
import com.moch.swiftbank.Registro.Password.SeguridadI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Login {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private SeguridadI seguridad;

    public boolean validarCredenciales(String usuario, String password) {
        // 1. Buscar el usuario en la base de datos
        Usuarios usuarioEncontrado = usuariosRepository.findByUsername(usuario);
        if (usuarioEncontrado == null) {
            return false;
        }
        // 2. Comparar la contraseña ingresada con la contraseña hasheada en la base de datos
        String hashedPassword = usuarioEncontrado.getPassword();
        return seguridad.passwordEncoder().matches(password, hashedPassword);
    }
}