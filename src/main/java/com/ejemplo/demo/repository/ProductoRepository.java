package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private final List<Producto> productos = new ArrayList<>();
    private long contadorId = 1;

    public List<Producto> findAll() {
        return productos;
    }

    public Optional<Producto> findById(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Producto save(Producto producto) {
        if (producto.getId() == null) {
            producto.setId(contadorId++);
            productos.add(producto);
        } else {
            deleteById(producto.getId());
            productos.add(producto);
        }
        return producto;
    }

    public void deleteById(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }
}
