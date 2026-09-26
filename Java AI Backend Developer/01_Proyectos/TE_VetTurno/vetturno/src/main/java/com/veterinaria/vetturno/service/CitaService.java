/*
 * Esta clase se encarga de la logica de negocio, validacion de reglas de agendamiento y gestion de citas.
 * Los datos vienen desde el CitaController (como DTOs) e interactuan con CitaRepository, MascotaRepository y VeterinarioRepository.
 */
package com.veterinaria.vetturno.service;

import com.veterinaria.vetturno.dto.CitaDTO;
import com.veterinaria.vetturno.dto.CitaRequest;
import com.veterinaria.vetturno.model.Cita;
import com.veterinaria.vetturno.model.Mascota;
import com.veterinaria.vetturno.model.Veterinario;
import com.veterinaria.vetturno.repository.CitaRepository;
import com.veterinaria.vetturno.repository.MascotaRepository;
import com.veterinaria.vetturno.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    public CitaService(CitaRepository citaRepository,
                       MascotaRepository mascotaRepository,
                       VeterinarioRepository veterinarioRepository) {
        this.citaRepository = citaRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    public CitaDTO agendarCita(CitaRequest request) {
        if (request.getFechaHora() == null || request.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha y hora de la cita debe ser futura.");
        }

        Mascota mascota = mascotaRepository.findById(request.getMascotaId())
                .orElseThrow(() -> new IllegalArgumentException("Mascota no encontrada con ID: " + request.getMascotaId()));

        Veterinario veterinario = veterinarioRepository.findById(request.getVeterinarioId())
                .orElseThrow(() -> new IllegalArgumentException("Veterinario no encontrado con ID: " + request.getVeterinarioId()));

        boolean horarioOcupado = citaRepository.existsByVeterinarioIdAndFechaHora(veterinario.getId(), request.getFechaHora());
        if (horarioOcupado) {
            throw new IllegalArgumentException("El veterinario " + veterinario.getNombre() + " ya tiene una cita agendada para esa fecha y hora.");
        }

        Cita nuevaCita = new Cita(
                request.getFechaHora(),
                request.getMotivo(),
                mascota,
                veterinario
        );

        Cita guardada = citaRepository.save(nuevaCita);
        return mapearADTO(guardada);
    }

    public List<CitaDTO> listarCitas() {
        return citaRepository.findAll()
                .stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    public List<CitaDTO> listarCitasPorVeterinario(Long veterinarioId) {
        if (!veterinarioRepository.existsById(veterinarioId)) {
            throw new IllegalArgumentException("Veterinario no encontrado con ID: " + veterinarioId);
        }

        return citaRepository.findByVeterinarioId(veterinarioId)
                .stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    private CitaDTO mapearADTO(Cita cita) {
        return new CitaDTO(
                cita.getId(),
                cita.getFechaHora(),
                cita.getMotivo(),
                cita.getMascota().getNombre(),
                cita.getMascota().getPropietario().getNombre(),
                cita.getVeterinario().getNombre()
        );
    }
}
