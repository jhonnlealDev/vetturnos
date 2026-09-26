/*
 * Esta clase representa el DTO de entrada para recibir la informacion necesaria al registrar un nuevo usuario en el sistema.
 * Los datos vienen desde la peticion HTTP en el AuthController y van hacia el AuthService.
 */
package com.veterinaria.vetturno.dto;

public class RegistroRequest {

    private String email;
    private String password;

    public RegistroRequest() {
    }

    public RegistroRequest(String email, String password) {
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
