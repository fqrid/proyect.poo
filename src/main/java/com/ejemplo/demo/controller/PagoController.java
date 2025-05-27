package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Pago;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final List<Pago> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<Pago> obtenerTodos() {
        return lista;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPorId(@PathVariable Long id) {
        return lista.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pedido/{pedidoId}")
    public List<Pago> obtenerPorPedidoId(@PathVariable Long pedidoId) {
        return lista.stream()
                .filter(p -> p.getPedidoId().equals(pedidoId))
                .toList();
    }

    @GetMapping("/metodo/{metodoId}")
    public List<Pago> obtenerPorMetodoId(@PathVariable Long metodoId) {
        return lista.stream()
                .filter(p -> p.getMetodoId().equals(metodoId))
                .toList();
    }

    @PostMapping
    public ResponseEntity<Pago> crear(@RequestBody Pago pago) {
        pago.setId(idCounter++);
        lista.add(pago);
        return ResponseEntity.ok(pago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Long id, @RequestBody Pago pagoNuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                pagoNuevo.setId(id);
                lista.set(i, pagoNuevo);
                return ResponseEntity.ok(pagoNuevo);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = lista.removeIf(p -> p.getId().equals(id));
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/estado/{estadoPago}")
    public List<Pago> obtenerPorEstado(@PathVariable String estadoPago) {
        return lista.stream()
                .filter(p -> p.getEstadoPago().equalsIgnoreCase(estadoPago))
                .toList();
    }
}