package com.devsenior.campusFlow.usuarios.dto;

import com.devsenior.campusFlow.usuarios.model.RolUsuario;
import com.devsenior.campusFlow.usuarios.model.TemaVisual;
import com.devsenior.campusFlow.usuarios.model.Usuario;

public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String email;
    private RolUsuario rol;
    private TemaVisual tema;
    private Boolean notificacionesActivas;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Long id, String nombre, String email, RolUsuario rol, TemaVisual tema, Boolean notificacionesActivas) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.tema = tema;
        this.notificacionesActivas = notificacionesActivas;
    }

    public UsuarioResponse(Usuario usuario) {
        if (usuario != null) {
            this.id = usuario.getId();
            this.nombre = usuario.getNombre();
            this.email = usuario.getEmail();
            this.rol = usuario.getRol();
            if (usuario.getPreferencias() != null) {
                this.tema = usuario.getPreferencias().getTema();
                this.notificacionesActivas = usuario.getPreferencias().isNotificacionesActivas();
            }
        }
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
