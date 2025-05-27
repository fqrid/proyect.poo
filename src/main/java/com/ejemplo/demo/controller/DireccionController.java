package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Direccion;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    private final List<Direccion> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Direccion> obtenerTodas() {
        return lista;
    }

    @GetMapping("/{id}")
    public Direccion obtenerPorId(@PathVariable Long id) {
        return lista.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Direccion> obtenerPorClienteId(@PathVariable Long clienteId) {
        return lista.stream()
                .filter(d -> d.getClienteId().equals(clienteId))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Direccion crear(@RequestBody Direccion direccion) {
        direccion.setId(idCounter++);
        lista.add(direccion);
        return direccion;
    }

    @PostMapping("/cliente/{clienteId}")
    public Direccion crearParaCliente(@PathVariable Long clienteId, @RequestBody Direccion direccion) {
        direccion.setId(idCounter++);
        direccion.setClienteId(clienteId);
        lista.add(direccion);
        return direccion;
    }

    @PutMapping("/{id}")
    public Direccion actualizar(@PathVariable Long id, @RequestBody Direccion direccionNueva) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                direccionNueva.setId(id);
                lista.set(i, direccionNueva);
                return direccionNueva;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        lista.removeIf(d -> d.getId().equals(id));
    }

    @DeleteMapping("/cliente/{clienteId}")
    public void eliminarPorCliente(@PathVariable Long clienteId) {
        lista.removeIf(d -> d.getClienteId().equals(clienteId));
    }
}