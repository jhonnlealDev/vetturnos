/*
 * Este controlador expone los endpoints REST para la gestion de Propietarios.
 * Los datos vienen desde las peticiones HTTP externas y se envian hacia el PropietarioService.
 */
package com.veterinaria.vetturno.controller;

import com.veterinaria.vetturno.dto.PropietarioDTO;
import com.veterinaria.vetturno.dto.PropietarioRequest;
import com.veterinaria.vetturno.service.PropietarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping
    public ResponseEntity<PropietarioDTO> crearPropietario(@Valid @RequestBody PropietarioRequest request) {
        PropietarioDTO nuevo = propietarioService.crearPropietario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<PropietarioDTO>> listarPropietarios() {
        List<PropietarioDTO> lista = propietarioService.listarPropietarios();
        return ResponseEntity.ok(lista);
    }
}
