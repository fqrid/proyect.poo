package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Direccion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DireccionRepository {
    private final List<Direccion> direcciones = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void guardar(Direccion d) {
        if (d.getId() == null) {
            d.setId(autoId.getAndIncrement());
        }
        direcciones.add(d);
    }

    public Direccion eliminar(int id) {
        for (int i = 0; i < direcciones.size(); i++) {
            if (direcciones.get(i).getId().equals(id)) {
                return direcciones.remove(i);
            }
        }
        return null;
    }

    public Direccion actualizar(int id, Direccion nuevo) {
        for (int i = 0; i < direcciones.size(); i++) {
            if (direcciones.get(i).getId().equals(id)) {
                nuevo.setId(id);
                direcciones.set(i, nuevo);
                return nuevo;
            }
        }
        return null;
    }

    public Direccion obtener(int id) {
        for (Direccion d : direcciones) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public List<Direccion> obtenerTodos() {
        return new ArrayList<>(direcciones);
    }
}