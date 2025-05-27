package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.CarritoCompra;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carritos")
public class CarritoCompraController {
    private List<CarritoCompra> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<CarritoCompra> obtenerTodos() {
        return lista;
    }

    @GetMapping("/{id}")
    public CarritoCompra obtenerPorId(@PathVariable Long id) {
        Optional<CarritoCompra> resultado = lista.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
        return resultado.orElse(null);
    }

    @GetMapping("/usuario/{usuarioId}")
    public CarritoCompra obtenerPorUsuarioId(@PathVariable Long usuarioId) {
        Optional<CarritoCompra> resultado = lista.stream()
                .filter(c -> c.getUsuarioId().equals(usuarioId))
                .findFirst();
        return resultado.orElse(null);
    }

    @PostMapping
    public CarritoCompra crear(@RequestBody CarritoCompra carrito) {
        // Verificar si ya existe un carrito para este usuario
        Optional<CarritoCompra> carritoExistente = lista.stream()
                .filter(c -> c.getUsuarioId().equals(carrito.getUsuarioId()))
                .findFirst();

        if (carritoExistente.isPresent()) {
            return carritoExistente.get();
        }

        carrito.setId(idCounter++);
        lista.add(carrito);
        return carrito;
    }

    @PutMapping("/{id}")
    public CarritoCompra actualizar(@PathVariable Long id, @RequestBody CarritoCompra nuevoCarrito) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                nuevoCarrito.setId(id);
                lista.set(i, nuevoCarrito);
                return nuevoCarrito;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        lista.removeIf(c -> c.getId().equals(id));
    }
}