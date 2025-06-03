package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Pago;
import java.util.*;

public class PagoRepository {
    private final Map<String, Pago> datos = new HashMap<>();

    public Pago save(Pago pago) {
        datos.put(pago.getId(), pago);
        return pago;
    }

    public Optional<Pago> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Pago> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
