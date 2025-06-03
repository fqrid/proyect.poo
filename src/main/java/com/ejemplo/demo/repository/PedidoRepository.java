package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Pedido;
import java.util.*;

public class PedidoRepository {
    private final Map<Long, Pedido> data = new HashMap<>();
    private long currentId = 1;

    public Pedido save(Pedido item) {
        if (item.getId() == null) {
            item.setId(currentId++);
        }
        data.put(item.getId(), item);
        return item;
    }

    public Optional<Pedido> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<Pedido> findAll() {
        return new ArrayList<>(data.values());
    }

    public void deleteById(Long id) {
        data.remove(id);
    }
}