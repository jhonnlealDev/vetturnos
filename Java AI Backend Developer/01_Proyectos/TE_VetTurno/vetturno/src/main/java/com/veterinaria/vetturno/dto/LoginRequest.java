/*
 * Esta clase representa el DTO de entrada para recibir las credenciales de inicio de sesion (email y password).
 * Los datos vienen desde la peticion HTTP en el AuthController y van hacia el AuthService para autenticar al usuario.
 */
package com.veterinaria.vetturno.dto;

public class LoginRequest {

    private String email;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
