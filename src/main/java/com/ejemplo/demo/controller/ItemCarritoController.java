package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.ItemCarrito;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items-carrito")
public class ItemCarritoController {
    private List<ItemCarrito> lista = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public List<ItemCarrito> obtenerTodos() {
        return lista;
    }

    @GetMapping("/{id}")
    public ItemCarrito obtenerPorId(@PathVariable Long id) {
        Optional<ItemCarrito> resultado = lista.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
        return resultado.orElse(null);
    }

    @GetMapping("/carrito/{carritoId}")
    public List<ItemCarrito> obtenerPorCarritoId(@PathVariable Long carritoId) {
        return lista.stream()
                .filter(item -> item.getCarritoId().equals(carritoId))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ItemCarrito crear(@RequestBody ItemCarrito item) {
        // Verificar si ya existe un item con el mismo producto en el carrito
        Optional<ItemCarrito> itemExistente = lista.stream()
                .filter(i -> i.getCarritoId().equals(item.getCarritoId())
                        && i.getProductoId().equals(item.getProductoId()))
                .findFirst();

        if (itemExistente.isPresent()) {
            // Si existe, actualizar la cantidad
            ItemCarrito itemActual = itemExistente.get();
            itemActual.setCantidad(itemActual.getCantidad() + item.getCantidad());
            return itemActual;
        }

        item.setId(idCounter++);
        lista.add(item);
        return item;
    }

    @PutMapping("/{id}")
    public ItemCarrito actualizar(@PathVariable Long id, @RequestBody ItemCarrito nuevoItem) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) {
                nuevoItem.setId(id);
                lista.set(i, nuevoItem);
                return nuevoItem;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        lista.removeIf(item -> item.getId().equals(id));
    }

    @DeleteMapping("/carrito/{carritoId}")
    public void eliminarPorCarritoId(@PathVariable Long carritoId) {
        lista.removeIf(item -> item.getCarritoId().equals(carritoId));
    }
}