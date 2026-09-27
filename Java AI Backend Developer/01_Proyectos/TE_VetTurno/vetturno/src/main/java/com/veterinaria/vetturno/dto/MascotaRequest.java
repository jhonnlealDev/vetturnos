/*
 * Esta clase representa el DTO de entrada para recibir los datos de una Mascota asociada a un Propietario.
 * Los datos vienen desde la peticion HTTP en el controlador y van hacia el servicio de mascotas.
 */
package com.veterinaria.vetturno.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MascotaRequest {

    @NotBlank(message = "El nombre es obligatorio.")
    private String nombre;

    @NotBlank(message = "La especie es obligatoria.")
    private String especie;

    private String raza; // opcional

    @NotNull(message = "El ID del propietario es obligatorio.")
    private Long propietarioId;

    public MascotaRequest() {
    }

    public MascotaRequest(String nombre, String especie, String raza, Long propietarioId) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.propietarioId = propietarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Long getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(Long propietarioId) {
        this.propietarioId = propietarioId;
    }
}
