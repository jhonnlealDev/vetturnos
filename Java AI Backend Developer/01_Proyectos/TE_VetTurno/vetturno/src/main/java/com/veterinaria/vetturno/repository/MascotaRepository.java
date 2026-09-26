/*
 * Esta interfaz se encarga del acceso a datos para la entidad Mascota mediante Spring Data JPA.
 * Los datos vienen desde la capa de servicio e interactuan con la tabla 'mascotas' en MySQL.
 */
package com.veterinaria.vetturno.repository;

import com.veterinaria.vetturno.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
