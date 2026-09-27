/*
 * Esta clase representa el DTO de entrada para recibir la informacion necesaria al crear o actualizar un Propietario.
 * Los datos vienen desde la peticion HTTP en el controlador y van hacia el servicio de propietarios.
 */
package com.veterinaria.vetturno.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class PropietarioRequest {

    @NotBlank(message = "El nombre es obligatorio.")
    private String nombre;

    @NotBlank(message = "El telefono es obligatorio.")
    private String telefono;

    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "El email debe tener un formato valido.")
    private String email;

    public PropietarioRequest() {
    }

    public PropietarioRequest(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
