package com.example.demo.controller;

import com.example.demo.model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private List<Producto> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Producto> obtenerTodos() {
        return lista;
    }

    @GetMapping("/<built-in function id>")
    public Producto obtenerPorId(@PathVariable Long id) {
        Optional<Producto> resultado = lista.stream().filter(m -> m.getId().equals(id)).findFirst();
        return resultado.orElse(null);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto modelo) {
        modelo.setId(idCounter++);
        lista.add(modelo);
        return modelo;
    }

    @PutMapping("/<built-in function id>")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto nuevoModelo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                nuevoModelo.setId(id);
                lista.set(i, nuevoModelo);
                return nuevoModelo;
            }
        }
        return null;
    }

    @DeleteMapping("/<built-in function id>")
    public void eliminar(@PathVariable Long id) {
        lista.removeIf(m -> m.getId().equals(id));
    }
}
