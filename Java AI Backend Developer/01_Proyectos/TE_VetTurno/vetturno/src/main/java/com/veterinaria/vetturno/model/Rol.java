/*
 * Este enum define los roles del sistema (USER y ADMIN) para el control de acceso y autorizacion.
 * Los datos se utilizan en la entidad Usuario y en la configuracion de Spring Security.
 */
package com.veterinaria.vetturno.model;

public enum Rol {
    USER,
    ADMIN
}
