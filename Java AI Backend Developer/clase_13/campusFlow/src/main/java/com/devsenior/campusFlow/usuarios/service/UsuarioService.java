package com.devsenior.campusFlow.usuarios.service;

import com.devsenior.campusFlow.usuarios.model.Usuario;
import com.devsenior.campusFlow.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }
}
