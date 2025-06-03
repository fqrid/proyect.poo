package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Descuento;
import java.util.*;

public class DescuentoRepository {
    private final Map<Long, Descuento> datos = new HashMap<>();
    private Long currentId = 1L;

    public Descuento save(Descuento obj) {
        if (obj.getId() == null) obj.setId(currentId++);
        datos.put(obj.getId(), obj);
        return obj;
    }

    public Optional<Descuento> findById(Long id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Descuento> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(Long id) {
        datos.remove(id);
    }
}