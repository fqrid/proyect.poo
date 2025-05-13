package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Comentario;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    private final List<Comentario> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Comentario> obtenerTodos() {
        return lista;
    }

    @GetMapping("/{id}")
    public Comentario obtenerPorId(@PathVariable Long id) {
        return lista.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Comentario crear(@RequestBody Comentario comentario) {
        comentario.setId(idCounter++);
        lista.add(comentario);
        return comentario;
    }

    @PutMapping("/{id}")
    public Comentario actualizar(@PathVariable Long id, @RequestBody Comentario comentarioNuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                comentarioNuevo.setId(id);
                lista.set(i, comentarioNuevo);
                return comentarioNuevo;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        lista.removeIf(c -> c.getId().equals(id));
    }
}
