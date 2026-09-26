/*
 * Esta interfaz se encarga del acceso a datos para la entidad Propietario mediante Spring Data JPA.
 * Los datos vienen desde la capa de servicio e interactuan con la tabla 'propietarios' en MySQL.
 */
package com.veterinaria.vetturno.repository;

import com.veterinaria.vetturno.model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
}
