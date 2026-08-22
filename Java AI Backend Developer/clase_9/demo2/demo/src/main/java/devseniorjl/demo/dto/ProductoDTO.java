package devseniorjl.demo.dto;
import devseniorjl.demo.model.Producto;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    private String marca;

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.stock = producto.getStock();
        this.categoria = producto.getCategoria() != null
                ? producto.getCategoria().getNombre()
                : null;
        this.marca = producto.getMarca() != null
                ? producto.getMarca().getNombre()
                : null;
    }

    // Getters de todos los campos
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }
}
