/*
 * Esta clase representa la estructura unificada de respuesta de errores devuelta por la API cuando ocurre una excepcion.
 * Los datos son construidos en el GlobalExceptionHandler y se envian en el cuerpo de la respuesta HTTP.
 */
package com.veterinaria.vetturno.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiError {

    private int status;
    private String mensaje;
    private Map<String, String> erroresPorCampo;
    private LocalDateTime timestamp;

    public ApiError() {
    }

    public ApiError(int status, String mensaje, Map<String, String> erroresPorCampo) {
        this.status = status;
        this.mensaje = mensaje;
        this.erroresPorCampo = erroresPorCampo;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Map<String, String> getErroresPorCampo() {
        return erroresPorCampo;
    }

    public void setErroresPorCampo(Map<String, String> erroresPorCampo) {
        this.erroresPorCampo = erroresPorCampo;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
