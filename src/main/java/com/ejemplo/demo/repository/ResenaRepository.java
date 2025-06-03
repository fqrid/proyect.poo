package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Resena;
import java.util.*;

public class ResenaRepository {
    private final Map<String, Resena> datos = new HashMap<>();

    public Resena save(Resena obj) {
        datos.put(obj.getId(), obj);
        return obj;
    }

    public Optional<Resena> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Resena> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
