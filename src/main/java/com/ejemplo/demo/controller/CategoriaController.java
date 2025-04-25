package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private List<Categoria> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Categoria> obtenerTodos() {
        return lista;
    }

    @GetMapping("/{id}")
    public Categoria obtenerPorId(@PathVariable Long id) {
        Optional<Categoria> resultado = lista.stream().filter(m -> m.getId().equals(id)).findFirst();
        return resultado.orElse(null);
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria modelo) {
        modelo.setId(idCounter++);
        lista.add(modelo);
        return modelo;
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Long id, @RequestBody Categoria nuevoModelo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                nuevoModelo.setId(id);
                lista.set(i, nuevoModelo);
                return nuevoModelo;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        lista.removeIf(m -> m.getId().equals(id));
    }
}