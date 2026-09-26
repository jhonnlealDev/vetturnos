/*
 * Esta interfaz se encarga del acceso a datos para la entidad Usuario mediante Spring Data JPA.
 * Ofrece metodos para buscar usuarios por su email y verificar su existencia en la base de datos MySQL.
 */
package com.veterinaria.vetturno.repository;

import com.veterinaria.vetturno.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);
}
