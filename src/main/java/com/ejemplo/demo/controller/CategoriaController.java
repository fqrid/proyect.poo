package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final List<Categoria> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Categoria> obtenerTodos() {
        return lista;
    }

    @GetMapping("/{id}")
    public Categoria obtenerPorId(@PathVariable Long id) {
        return lista.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        categoria.setId(idCounter++);
        lista.add(categoria);
        return categoria;
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Long id, @RequestBody Categoria categoriaNueva) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                categoriaNueva.setId(id);
                lista.set(i, categoriaNueva);
                return categoriaNueva;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        lista.removeIf(c -> c.getId().equals(id));
    }
}
