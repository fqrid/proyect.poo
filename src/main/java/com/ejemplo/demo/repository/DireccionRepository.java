package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Direccion;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DireccionRepository {
    private final ArrayList<Direccion> direcciones = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);
    public void agregar(Direccion direccion) {
        direccion.setId(autoId.getAndIncrement());
        direcciones.add(direccion);
    }

    public Direccion obtener(int id) {
        for (Direccion d : direcciones) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    public ArrayList<Direccion> obtenerTodas() {
        return direcciones;
    }

    public Direccion actualizar(int id, Direccion actualizada) {
        for (int i = 0; i < direcciones.size(); i++) {
            if (direcciones.get(i).getId() == id) {
                actualizada.setId(id);
                direcciones.set(i, actualizada);
                return actualizada;
            }
        }
        return null;
    }

    public Direccion eliminar(int id) {
        for (int i = 0; i < direcciones.size(); i++) {
            if (direcciones.get(i).getId() == id) {
                return direcciones.remove(i);
            }
        }
        return null;
    }
}