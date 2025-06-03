package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Rol;
import java.util.*;

public class RolRepository {
    private final Map<Long, Rol> data = new HashMap<>();
    private long currentId = 1;

    public Rol save(Rol item) {
        if (item.getId() == null) {
            item.setId(currentId++);
        }
        data.put(item.getId(), item);
        return item;
    }

    public Optional<Rol> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<Rol> findAll() {
        return new ArrayList<>(data.values());
    }

    public void deleteById(Long id) {
        data.remove(id);
    }
}