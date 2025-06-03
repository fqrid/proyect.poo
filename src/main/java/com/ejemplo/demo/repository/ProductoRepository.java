package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Producto;
import java.util.*;

public class ProductoRepository {
    private final Map<String, Producto> datos = new HashMap<>();

    public Producto save(Producto producto) {
        datos.put(producto.getId(), producto);
        return producto;
    }

    public Optional<Producto> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Producto> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
