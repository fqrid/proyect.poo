package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Direccion;
import java.util.*;

public class DireccionRepository {
    private final Map<String, Direccion> datos = new HashMap<>();

    public Direccion save(Direccion obj) {
        datos.put(obj.getId(), obj);
        return obj;
    }

    public Optional<Direccion> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Direccion> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
