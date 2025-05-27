package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.MetodoPago;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/metodos-pago")
public class MetodoPagoController {

    private final List<MetodoPago> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<MetodoPago> obtenerTodos() {
        return lista;
    }

    @GetMapping("/{id}")
    public MetodoPago obtenerPorId(@PathVariable Long id) {
        return lista.stream()
                .filter(mp -> mp.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<MetodoPago> obtenerPorClienteId(@PathVariable Long clienteId) {
        return lista.stream()
                .filter(mp -> mp.getClienteId().equals(clienteId))
                .toList();
    }

    @PostMapping
    public MetodoPago crear(@RequestBody MetodoPago metodoPago) {
        metodoPago.setId(idCounter++);
        lista.add(metodoPago);
        return metodoPago;
    }

    @PutMapping("/{id}")
    public MetodoPago actualizar(@PathVariable Long id, @RequestBody MetodoPago metodoPagoNuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                metodoPagoNuevo.setId(id);
                lista.set(i, metodoPagoNuevo);
                return metodoPagoNuevo;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        lista.removeIf(mp -> mp.getId().equals(id));
    }
}