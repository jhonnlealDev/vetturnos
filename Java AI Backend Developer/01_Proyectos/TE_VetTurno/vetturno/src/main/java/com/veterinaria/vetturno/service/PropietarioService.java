/*
 * Esta clase se encarga de la logica de negocio y gestion de operaciones CRUD para los Propietarios.
 * Los datos vienen desde el PropietarioController (como DTOs) e interactuan con el PropietarioRepository.
 */
package com.veterinaria.vetturno.service;

import com.veterinaria.vetturno.dto.PropietarioDTO;
import com.veterinaria.vetturno.dto.PropietarioRequest;
import com.veterinaria.vetturno.model.Propietario;
import com.veterinaria.vetturno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    // Inyeccion de dependencias por constructor
    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    public PropietarioDTO crearPropietario(PropietarioRequest request) {
        Propietario propietario = new Propietario(
                request.getNombre(),
                request.getTelefono(),
                request.getEmail());
        Propietario guardado = propietarioRepository.save(propietario);
        return mapearADTO(guardado);
    }

    public List<PropietarioDTO> listarPropietarios() {
        return propietarioRepository.findAll()
                .stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    private PropietarioDTO mapearADTO(Propietario propietario) {
        return new PropietarioDTO(
                propietario.getId(),
                propietario.getNombre(),
                propietario.getTelefono(),
                propietario.getEmail());
    }
}
