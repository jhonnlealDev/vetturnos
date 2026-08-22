/*package devseniorjl.demo.service;

import devseniorjl.demo.model.Producto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    private List<Producto> productos = new ArrayList<>();
    public List<Producto> listarProductos() {
        return productos;
    }

    public Producto agregarProducto(Producto producto) {
        productos.add(producto);
        return producto;
    }
}*/

package devseniorjl.demo.service;

import devseniorjl.demo.model.Categoria;
import devseniorjl.demo.model.Marca;
import devseniorjl.demo.model.Producto;
import devseniorjl.demo.repository.CategoriaRepository;
import devseniorjl.demo.repository.MarcaRepository;
import devseniorjl.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final MarcaRepository marcaRepository;

    public ProductoService(ProductoRepository productoRepository,
                           CategoriaRepository categoriaRepository,
                           MarcaRepository marcaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.marcaRepository = marcaRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto agregarProducto(Producto producto) {
        if (producto.getCategoria() != null && producto.getCategoria().getId() != null) {
            Categoria categoria = categoriaRepository.findById(producto.getCategoria().getId()).orElse(null);
            producto.setCategoria(categoria);
        }

        if (producto.getMarca() != null && producto.getMarca().getId() != null) {
            Marca marca = marcaRepository.findById(producto.getMarca().getId()).orElse(null);
            producto.setMarca(marca);
        }

        return productoRepository.save(producto);
    }
}

