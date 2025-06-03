package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Notificacion;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class NotificacionesRepository {
    private final ArrayList<Notificacion> notificaciones = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregar(Notificacion notificacion) {
        notificacion.setId(autoId.getAndIncrement());
        notificaciones.add(notificacion);
    }

    public Notificacion eliminar(int id) {
        for (int i = 0; i < notificaciones.size(); i++) {
            if (notificaciones.get(i).getId() == id) {
                return notificaciones.remove(i);
            }
        }
        return null;
    }

    public Notificacion actualizar(int id, Notificacion actualizada) {
        for (int i = 0; i < notificaciones.size(); i++) {
            if (notificaciones.get(i).getId() == id) {
                actualizada.setId(id);
                notificaciones.set(i, actualizada);
                return actualizada;
            }
        }
        return null;
    }

    public Notificacion obtener(int id) {
        for (Notificacion n : notificaciones) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }

    public ArrayList<Notificacion> obtenerTodos() {
        return notificaciones;
    }
}
