package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.MetodoPago;
import java.util.*;

public class MetodoPagoRepository {
    private final Map<Long, MetodoPago> data = new HashMap<>();
    private long currentId = 1;

    public MetodoPago save(MetodoPago item) {
        if (item.getId() == null) {
            item.setId(currentId++);
        }
        data.put(item.getId(), item);
        return item;
    }

    public Optional<MetodoPago> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<MetodoPago> findAll() {
        return new ArrayList<>(data.values());
    }

    public void deleteById(Long id) {
        data.remove(id);
    }
}