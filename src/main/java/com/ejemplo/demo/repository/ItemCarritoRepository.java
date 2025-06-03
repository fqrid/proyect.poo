package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.ItemCarrito;
import java.util.*;

public class ItemCarritoRepository {
    private final List<ItemCarrito> datos = new ArrayList<>();

    public void agregar(ItemCarrito item) {
        datos.add(item);
    }

    public Optional<ItemCarrito> obtenerPorId(String id) {
        return datos.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public List<ItemCarrito> obtenerTodos() {
        return datos;
    }

    public boolean eliminarPorId(String id) {
        return datos.removeIf(i -> i.getId().equals(id));
    }

    public boolean actualizar(ItemCarrito item) {
        Optional<ItemCarrito> existente = obtenerPorId(item.getId());
        if (existente.isPresent()) {
            datos.remove(existente.get());
            datos.add(item);
            return true;
        }
        return false;
    }
}
