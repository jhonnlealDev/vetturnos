/*
 * Este controlador expone los endpoints REST para el agendamiento y la consulta de citas veterinarias.
 * Los datos vienen desde las peticiones HTTP externas y se envian hacia el CitaService.
 */
package com.veterinaria.vetturno.controller;

import com.veterinaria.vetturno.dto.CitaDTO;
import com.veterinaria.vetturno.dto.CitaRequest;
import com.veterinaria.vetturno.service.CitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping
    public ResponseEntity<CitaDTO> agendarCita(@RequestBody CitaRequest request) {
        CitaDTO nuevaCita = citaService.agendarCita(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCita);
    }

    @GetMapping
    public ResponseEntity<List<CitaDTO>> listarCitas() {
        List<CitaDTO> lista = citaService.listarCitas();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/veterinario/{id}")
    public ResponseEntity<List<CitaDTO>> listarCitasPorVeterinario(@PathVariable Long id) {
        List<CitaDTO> lista = citaService.listarCitasPorVeterinario(id);
        return ResponseEntity.ok(lista);
    }
}
