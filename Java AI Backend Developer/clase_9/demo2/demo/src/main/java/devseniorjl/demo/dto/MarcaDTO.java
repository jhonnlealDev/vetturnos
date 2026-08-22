package devseniorjl.demo.dto;

import devseniorjl.demo.model.Marca;

public class MarcaDTO {
    private Long id;
    private String nombre;

    public MarcaDTO(Marca marca) {
        this.id = marca.getId();
        this.nombre = marca.getNombre();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
