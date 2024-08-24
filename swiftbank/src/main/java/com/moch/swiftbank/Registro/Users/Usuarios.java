package com.moch.swiftbank.Registro.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "users")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    public Usuarios() {
    }

    public Usuarios(String name, String apellido, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = ""; // You should add email validation and set it here
    }
}