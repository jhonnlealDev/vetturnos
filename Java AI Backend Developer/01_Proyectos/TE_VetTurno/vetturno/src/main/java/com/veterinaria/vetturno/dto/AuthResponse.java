/*
 * Esta clase representa el DTO de salida para responder con el token JWT generado tras una autenticacion o registro exitoso.
 * Los datos se generan en el AuthService y se devuelven al cliente HTTP a traves del AuthController.
 */
package com.veterinaria.vetturno.dto;

public class AuthResponse {

    private String token;

    public AuthResponse() {
    }

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
