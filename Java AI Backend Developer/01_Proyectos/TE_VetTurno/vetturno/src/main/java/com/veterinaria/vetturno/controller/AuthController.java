/*
 * Este controlador expone los endpoints de autenticacion publica para el registro e inicio de sesion de usuarios.
 * Los datos vienen desde las peticiones HTTP externas y se envian hacia el AuthService.
 */
package com.veterinaria.vetturno.controller;

import com.veterinaria.vetturno.dto.AuthResponse;
import com.veterinaria.vetturno.dto.LoginRequest;
import com.veterinaria.vetturno.dto.RegistroRequest;
import com.veterinaria.vetturno.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registrar(@RequestBody RegistroRequest request) {
        AuthResponse response = authService.registrar(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
