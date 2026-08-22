package devseniorjl.demo.repository;

import devseniorjl.demo.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    // Spring Data JPA genera automáticamente toda la implementación
}
