/*
 * Esta clase representa el DTO de salida para transferir la informacion de un Propietario registrado.
 * Los datos se generan en la capa de servicio a partir de la entidad y van hacia el controlador para la respuesta HTTP.
 */
package com.veterinaria.vetturno.dto;

public class PropietarioDTO {

    private Long id;
    private String nombre;
    private String telefono;
    private String email;

    public PropietarioDTO() {
    }

    public PropietarioDTO(Long id, String nombre, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
