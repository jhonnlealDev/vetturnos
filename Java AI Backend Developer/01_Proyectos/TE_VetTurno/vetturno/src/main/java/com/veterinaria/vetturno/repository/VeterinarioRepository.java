/*
 * Esta interfaz se encarga del acceso a datos para la entidad Veterinario mediante Spring Data JPA.
 * Los datos vienen desde la capa de servicio e interactuan con la tabla 'veterinarios' en MySQL.
 */
package com.veterinaria.vetturno.repository;

import com.veterinaria.vetturno.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
