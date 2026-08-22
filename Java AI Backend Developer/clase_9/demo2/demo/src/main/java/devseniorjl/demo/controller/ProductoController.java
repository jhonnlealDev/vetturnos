package devseniorjl.demo.controller;

import devseniorjl.demo.dto.ProductoDTO;
import devseniorjl.demo.model.Producto;
import devseniorjl.demo.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoDTO> obtenerProductos() {
        return productoService.listarProductos()
                .stream()
                .map(ProductoDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ProductoDTO crearProducto(@RequestBody Producto producto) {
        Producto guardado = productoService.agregarProducto(producto);
        return new ProductoDTO(guardado);
    }
}
