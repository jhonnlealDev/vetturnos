/*
 * Esta clase se encarga de la logica de negocio y gestion de mascotas en la veterinaria.
 * Los datos vienen desde el MascotaController (como DTOs) e interactuan con MascotaRepository y PropietarioRepository.
 */
package com.veterinaria.vetturno.service;

import com.veterinaria.vetturno.dto.MascotaDTO;
import com.veterinaria.vetturno.dto.MascotaRequest;
import com.veterinaria.vetturno.model.Mascota;
import com.veterinaria.vetturno.model.Propietario;
import com.veterinaria.vetturno.repository.MascotaRepository;
import com.veterinaria.vetturno.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PropietarioRepository propietarioRepository;

    public MascotaService(MascotaRepository mascotaRepository, PropietarioRepository propietarioRepository) {
        this.mascotaRepository = mascotaRepository;
        this.propietarioRepository = propietarioRepository;
    }

    public MascotaDTO crearMascota(MascotaRequest request) {
        Propietario propietario = propietarioRepository.findById(request.getPropietarioId())
                .orElseThrow(() -> new IllegalArgumentException("Propietario no encontrado con ID: " + request.getPropietarioId()));

        Mascota mascota = new Mascota(
                request.getNombre(),
                request.getEspecie(),
                request.getRaza(),
                propietario
        );

        Mascota guardada = mascotaRepository.save(mascota);
        return mapearADTO(guardada);
    }

    public List<MascotaDTO> listarMascotas() {
        return mascotaRepository.findAll()
                .stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    private MascotaDTO mapearADTO(Mascota mascota) {
        return new MascotaDTO(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getEspecie(),
                mascota.getRaza(),
                mascota.getPropietario().getId(),
                mascota.getPropietario().getNombre()
        );
    }
}
