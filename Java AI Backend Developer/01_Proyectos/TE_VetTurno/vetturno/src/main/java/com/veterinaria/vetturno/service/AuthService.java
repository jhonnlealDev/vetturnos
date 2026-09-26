/*
 * Esta clase se encarga de la logica de autenticacion, registro de usuarios y generacion de tokens JWT.
 * Los datos vienen desde el AuthController (como DTOs) e interactuan con UsuarioRepository, PasswordEncoder, JwtService y AuthenticationManager.
 */
package com.veterinaria.vetturno.service;

import com.veterinaria.vetturno.dto.AuthResponse;
import com.veterinaria.vetturno.dto.LoginRequest;
import com.veterinaria.vetturno.dto.RegistroRequest;
import com.veterinaria.vetturno.model.Rol;
import com.veterinaria.vetturno.model.Usuario;
import com.veterinaria.vetturno.repository.UsuarioRepository;
import com.veterinaria.vetturno.security.JwtService;
import com.veterinaria.vetturno.security.UsuarioDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioDetailsService usuarioDetailsService;

    public AuthService(UsuarioRepository usuarioRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       AuthenticationManager authenticationManager,
                       UsuarioDetailsService usuarioDetailsService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.usuarioDetailsService = usuarioDetailsService;
    }

    public AuthResponse registrar(RegistroRequest request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El email ya se encuentra registrado.");
        }

        Usuario usuario = new Usuario(
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Rol.USER
        );

        usuarioRepository.save(usuario);

        UserDetails userDetails = usuarioDetailsService.loadUserByUsername(usuario.getEmail());
        String token = jwtService.generarToken(userDetails);
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetails userDetails = usuarioDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtService.generarToken(userDetails);
        return new AuthResponse(token);
    }
}
