package devseniorjl.demo.dto;

import devseniorjl.demo.model.Categoria;

public class CategoriaDTO {
    private Long id;
    private String nombre;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nombre = categoria.getNombre();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

