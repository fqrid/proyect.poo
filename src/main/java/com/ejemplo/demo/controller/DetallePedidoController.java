package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.DetallePedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/detalles-pedido")
public class DetallePedidoController {

    private final List<DetallePedido> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<DetallePedido> obtenerTodos() {
        return lista;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> obtenerPorId(@PathVariable Long id) {
        return lista.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pedido/{pedidoId}")
    public List<DetallePedido> obtenerPorPedidoId(@PathVariable Long pedidoId) {
        return lista.stream()
                .filter(d -> d.getPedidoId().equals(pedidoId))
                .toList();
    }

    @PostMapping
    public DetallePedido crear(@RequestBody DetallePedido detallePedido) {
        detallePedido.setId(idCounter++);
        lista.add(detallePedido);
        return detallePedido;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> actualizar(@PathVariable Long id, @RequestBody DetallePedido detalleNuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                detalleNuevo.setId(id);
                lista.set(i, detalleNuevo);
                return ResponseEntity.ok(detalleNuevo);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = lista.removeIf(d -> d.getId().equals(id));
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}