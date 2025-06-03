package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Factura;
import java.util.*;

public class FacturaRepository {
    private final Map<String, Factura> datos = new HashMap<>();

    public Factura save(Factura factura) {
        datos.put(factura.getId(), factura);
        return factura;
    }

    public Optional<Factura> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Factura> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
