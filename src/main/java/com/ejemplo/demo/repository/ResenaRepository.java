package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Resena;
import java.util.*;

public class ResenaRepository {
    private final Map<Long, Resena> data = new HashMap<>();
    private long currentId = 1;

    public Resena save(Resena item) {
        if (item.getId() == null) {
            item.setId(currentId++);
        }
        data.put(item.getId(), item);
        return item;
    }

    public Optional<Resena> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<Resena> findAll() {
        return new ArrayList<>(data.values());
    }

    public void deleteById(Long id) {
        data.remove(id);
    }
}