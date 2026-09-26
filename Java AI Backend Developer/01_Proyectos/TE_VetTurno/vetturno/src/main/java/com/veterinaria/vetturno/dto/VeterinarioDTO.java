/*
 * Esta clase representa el DTO de salida para transferir la informacion de un Veterinario registrado.
 * Los datos se generan en la capa de servicio a partir de la entidad y van hacia el controlador para la respuesta HTTP.
 */
package com.veterinaria.vetturno.dto;

public class VeterinarioDTO {

    private Long id;
    private String nombre;
    private String especialidad;

    public VeterinarioDTO() {
    }

    public VeterinarioDTO(Long id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
