/*
 * Esta clase se encarga de la logica de negocio y gestion de veterinarios en la clinica.
 * Los datos vienen desde el VeterinarioController (como DTOs) e interactuan con el VeterinarioRepository.
 */
package com.veterinaria.vetturno.service;

import com.veterinaria.vetturno.dto.VeterinarioDTO;
import com.veterinaria.vetturno.dto.VeterinarioRequest;
import com.veterinaria.vetturno.model.Veterinario;
import com.veterinaria.vetturno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    public VeterinarioDTO crearVeterinario(VeterinarioRequest request) {
        Veterinario veterinario = new Veterinario(
                request.getNombre(),
                request.getEspecialidad()
        );
        Veterinario guardado = veterinarioRepository.save(veterinario);
        return mapearADTO(guardado);
    }

    public List<VeterinarioDTO> listarVeterinarios() {
        return veterinarioRepository.findAll()
                .stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    private VeterinarioDTO mapearADTO(Veterinario veterinario) {
        return new VeterinarioDTO(
                veterinario.getId(),
                veterinario.getNombre(),
                veterinario.getEspecialidad()
        );
    }
}
