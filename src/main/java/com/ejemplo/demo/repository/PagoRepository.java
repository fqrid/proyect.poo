package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Pago;
import java.util.*;

public class PagoRepository {
    private final Map<Long, Pago> data = new HashMap<>();
    private long currentId = 1;

    public Pago save(Pago item) {
        if (item.getId() == null) {
            item.setId(currentId++);
        }
        data.put(item.getId(), item);
        return item;
    }

    public Optional<Pago> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<Pago> findAll() {
        return new ArrayList<>(data.values());
    }

    public void deleteById(Long id) {
        data.remove(id);
    }
}