package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Inventario;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class InventarioRepository {
    private final ArrayList<Inventario> inventarios = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarInventario(Inventario inventario) {
        inventario.setId(autoId.getAndIncrement());
        inventarios.add(inventario);
    }

    public Inventario eliminarInventario(int id) {
        for (int i = 0; i < inventarios.size(); i++) {
            if (inventarios.get(i).getId() == id) {
                return inventarios.remove(i);
            }
        }
        return null;
    }

    public Inventario actualizarInventario(int id, Inventario actualizado) {
        for (int i = 0; i < inventarios.size(); i++) {
            if (inventarios.get(i).getId() == id) {
                actualizado.setId(id);
                inventarios.set(i, actualizado);
                return actualizado;
            }
        }
        return null;
    }

    public Inventario obtenerInventario(int id) {
        for (Inventario i : inventarios) {
            if (i.getId() == id) return i;
        }
        return null;
    }

    public ArrayList<Inventario> obtenerInventarios() {
        return inventarios;
    }
}
