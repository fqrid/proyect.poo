package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Inventario;
import java.util.*;

public class InventarioRepository {
    private final Map<String, Inventario> datos = new HashMap<>();

    public Inventario save(Inventario inventario) {
        datos.put(inventario.getId(), inventario);
        return inventario;
    }

    public Optional<Inventario> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Inventario> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
