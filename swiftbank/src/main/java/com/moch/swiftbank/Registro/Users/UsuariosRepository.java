package com.moch.swiftbank.Registro.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findByUsername(String username);
    Usuarios findByEmail(String email);


}