/*
 * Esta clase representa el DTO de entrada para recibir la informacion de un Veterinario al crearlo o actualizarlo.
 * Los datos vienen desde la peticion HTTP en el controlador y van hacia el servicio de veterinarios.
 */
package com.veterinaria.vetturno.dto;

public class VeterinarioRequest {

    private String nombre;
    private String especialidad;

    public VeterinarioRequest() {
    }

    public VeterinarioRequest(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
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
