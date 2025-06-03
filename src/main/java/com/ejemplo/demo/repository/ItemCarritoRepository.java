package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.ItemCarrito;

import java.util.*;

public class ItemCarritoRepository {
    private final Map<String, ItemCarrito> items = new HashMap<>();

    public ItemCarrito save(ItemCarrito item) {
        items.put(item.getId(), item);
        return item;
    }

    public Optional<ItemCarrito> findById(String id) {
        return Optional.ofNullable(items.get(id));
    }

    public List<ItemCarrito> findAll() {
        return new ArrayList<>(items.values());
    }

    public void deleteById(String id) {
        items.remove(id);
    }
}
