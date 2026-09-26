/*
 * Esta interfaz se encarga del acceso a datos para la entidad Cita mediante Spring Data JPA.
 * Ofrece consultas derivadas para validar disponibilidad de horarios de veterinarios y listar citas.
 */
package com.veterinaria.vetturno.repository;

import com.veterinaria.vetturno.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    boolean existsByVeterinarioIdAndFechaHora(Long veterinarioId, LocalDateTime fechaHora);

    List<Cita> findByVeterinarioId(Long veterinarioId);
}
