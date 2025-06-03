package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.MetodoPago;
import java.util.*;

public class MetodoPagoRepository {
    private final Map<String, MetodoPago> datos = new HashMap<>();

    public MetodoPago save(MetodoPago metodo) {
        datos.put(metodo.getId(), metodo);
        return metodo;
    }

    public Optional<MetodoPago> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<MetodoPago> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
