package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Resena;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resenas")
public class ResenaController {
    private List<Resena> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Resena> obtenerTodas() {
        return lista;
    }

    @GetMapping("/{id}")
    public Resena obtenerPorId(@PathVariable Long id) {
        Optional<Resena> resultado = lista.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
        return resultado.orElse(null);
    }

    @GetMapping("/producto/{productoId}")
    public List<Resena> obtenerPorProducto(@PathVariable Long productoId) {
        return lista.stream()
                .filter(r -> r.getProductoId().equals(productoId))
                .toList();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Resena> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return lista.stream()
                .filter(r -> r.getUsuarioId().equals(usuarioId))
                .toList();
    }

    @PostMapping
    public Resena crear(@RequestBody Resena modelo) {
        modelo.setId(idCounter++);
        lista.add(modelo);
        return modelo;
    }

    @PutMapping("/{id}")
    public Resena actualizar(@PathVariable Long id, @RequestBody Resena nuevoModelo) {
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
        lista.removeIf(r -> r.getId().equals(id));
    }
}