package devseniorjl.demo.service;

import devseniorjl.demo.model.Categoria;
import devseniorjl.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll(); // 3. Usa el método del repositorio
    }

    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria); // 4. Guarda en la BD
    }
}
