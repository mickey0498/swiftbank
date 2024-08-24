package com.moch.swiftbank.Registro.Users;

import com.moch.swiftbank.Registro.Password.SeguridadI;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component

public class UsuariosService {
//Logica del negocio y las operaciones relacionadas a los usuarios

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UsuariosRepository usuariosRepository;


    //inyección de SeguridadI
    @Autowired
    private SeguridadI seguridad;

    //registro de usuarios
    //The UsuariosService uses the Usuarios class to create and manage user objects,
    // just like a construction company uses a blueprint to build houses.

    //validar el registro de usuarios y tambien verificar unicidad
    @Transactional
    public Usuarios registrarUsuario(Usuarios usuario) {
        // Create a new Usuarios object using the constructor
//        if (!usuario.validarUsuario(usuario.getUsuario())) {
//            throw new IllegalArgumentException("Usuario no valido. Solo puede contener letras y numeros");
//        }
//        if (usuariosRepository.existsByUsuario(usuario.getUsuario())) {
//            throw new IllegalArgumentException("Usuario ya existe");
//        }
//
//        if (usuariosRepository.existsByTelefono(usuario.getTelefono())) {
//            throw new IllegalArgumentException("El teléfono ya está en uso.");
//        }
//
//        if (usuariosRepository.existsByEmail(usuario.getEmail())) {
//            throw new IllegalArgumentException("El correo electrónico ya está en uso.");
//        }

        //hashing passwords antes de guardarla
        String hashedPassword = seguridad.passwordEncoder().encode(usuario.getPassword());

        //conversión de Password a hashedPassword para guardar en base de datos
        usuario.setPassword(hashedPassword);

        //imprime hashes (debug)
        System.out.println("Hashed password: " + hashedPassword);

        return usuariosRepository.save(usuario);
    }


//    public boolean existeUsuario(String usuario) {
//        return usuariosRepository.existsByUsuario(usuario);
//    }
//
//    public boolean existeEmail(String email) {
//        return usuariosRepository.existsByEmail(email);
//    }
//
//    public boolean existeTelefono(String telefono) {
//        return usuariosRepository.existsByTelefono(telefono);
//    }
//
    public Usuarios obtenerUsuarioPorNombre(String usuario) {
        return usuariosRepository.findByUsername(usuario);


}}

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);  
//
//        if (user == null) {
//            throw new UsernameNotFoundException("Usuario  
//                    no encontrado");
//        }
//        return new org.springframework.security.core.userdetails.User(  
//
//                user.getUsername(), user.getPassword(), user.getAuthorities()
//        );
//    }
//}    @Override
//public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    User user = userRepository.findByUsername(username);  
//
//    if (user == null) {
//        throw new UsernameNotFoundException("Usuario  
//                no encontrado");
//    }
//    return new org.springframework.security.core.userdetails.User(  
//
//            user.getUsername(), user.getPassword(), user.getAuthorities()
//    );




//    @Transactional
//    public Usuarios actualizarUsuario(Usuarios usuario) {
//        if (usuario.getId() == null) {
//            throw new IllegalArgumentException("El usuario debe tener un ID válido para actualizar.");
//        }
//        // Find the existing user by ID
//        Usuarios existingUser = usuariosRepository.findById(usuario.getId())
//                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado."));
//
//        // Update the user's information
//        existingUser.setNombre(usuario.getNombre());
//        existingUser.setApellido(usuario.getApellido());
//        existingUser.setTelefono(usuario.getTelefono());
//        existingUser.setEmail(usuario.getEmail());
//
//        // Save the updated user
//        return usuariosRepository.save(existingUser);
//    }
//}
//



