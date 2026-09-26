package com.devsenior.campusFlow.usuarios.repository;

import com.devsenior.campusFlow.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
