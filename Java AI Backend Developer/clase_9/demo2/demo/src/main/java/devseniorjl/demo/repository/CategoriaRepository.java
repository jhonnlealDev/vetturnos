package devseniorjl.demo.repository;

import devseniorjl.demo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Spring Data JPA genera automáticamente toda la implementación
}