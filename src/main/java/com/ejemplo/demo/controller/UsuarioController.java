package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private List<Usuario> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return lista;
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable Long id) {
        Optional<Usuario> resultado = lista.stream().filter(u -> u.getId().equals(id)).findFirst();
        return resultado.orElse(null);
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario modelo) {
        modelo.setId(idCounter++);
        lista.add(modelo);
        return modelo;
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario nuevoModelo) {
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
        lista.removeIf(u -> u.getId().equals(id));
    }
}
