package com.devsenior.campusFlow.usuarios.dto;

import com.devsenior.campusFlow.usuarios.model.RolUsuario;
import com.devsenior.campusFlow.usuarios.model.TemaVisual;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ActualizarUsuarioRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "El email debe tener un formato válido")
    private String email;

    private RolUsuario rol;

    private TemaVisual tema;

    private Boolean notificacionesActivas;

    public ActualizarUsuarioRequest() {
    }

    public ActualizarUsuarioRequest(String nombre, String email, RolUsuario rol, TemaVisual tema, Boolean notificacionesActivas) {
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.tema = tema;
        this.notificacionesActivas = notificacionesActivas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public TemaVisual getTema() {
        return tema;
    }

    public void setTema(TemaVisual tema) {
        this.tema = tema;
    }

    public Boolean getNotificacionesActivas() {
        return notificacionesActivas;
    }

    public void setNotificacionesActivas(Boolean notificacionesActivas) {
        this.notificacionesActivas = notificacionesActivas;
    }
}
