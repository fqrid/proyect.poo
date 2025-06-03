package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Inventario;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InventarioRepository {
    private final List<Inventario> inventarios = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void guardar(Inventario inventario) {
        if (inventario.getId() == null) {
            inventario.setId(autoId.getAndIncrement());
            inventarios.add(inventario);
        } else {
            actualizar(inventario.getId(), inventario);
        }
    }

    public Inventario eliminar(int id) {
        for (int i = 0; i < inventarios.size(); i++) {
            if (inventarios.get(i).getId() == id) {
                return inventarios.remove(i);
            }
        }
        return null;
    }

    public Inventario actualizar(int id, Inventario actualizado) {
        for (int i = 0; i < inventarios.size(); i++) {
            if (inventarios.get(i).getId() == id) {
                actualizado.setId(id);
                inventarios.set(i, actualizado);
                return actualizado;
            }
        }
        return null;
    }

    public Inventario obtener(int id) {
        for (Inventario i : inventarios) {
            if (i.getId() == id) return i;
        }
        return null;
    }

    public List<Inventario> obtenerTodos() {
        return new ArrayList<>(inventarios);
    }
}