package devseniorjl.demo.controller;

import devseniorjl.demo.model.Marca;
import devseniorjl.demo.service.MarcaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<Marca> obtenerMarcas() {
        return marcaService.listarMarcas();
    }

    @PostMapping
    public Marca crearMarca(@RequestBody Marca marca) {
        return marcaService.agregarMarca(marca);
    }
}
