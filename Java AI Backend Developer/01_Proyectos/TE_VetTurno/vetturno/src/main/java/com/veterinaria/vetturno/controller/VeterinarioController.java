/*
 * Este controlador expone los endpoints REST para la gestion de Veterinarios.
 * Los datos vienen desde las peticiones HTTP externas y se envian hacia el VeterinarioService.
 */
package com.veterinaria.vetturno.controller;

import com.veterinaria.vetturno.dto.VeterinarioDTO;
import com.veterinaria.vetturno.dto.VeterinarioRequest;
import com.veterinaria.vetturno.service.VeterinarioService;
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
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @PostMapping
    public ResponseEntity<VeterinarioDTO> crearVeterinario(@Valid @RequestBody VeterinarioRequest request) {
        VeterinarioDTO nuevo = veterinarioService.crearVeterinario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<VeterinarioDTO>> listarVeterinarios() {
        List<VeterinarioDTO> lista = veterinarioService.listarVeterinarios();
        return ResponseEntity.ok(lista);
    }
}
