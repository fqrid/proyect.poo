package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Notificacion;
import java.util.*;

/**
 * Repositorio en memoria para Notificacion, usando String como ID.
 * Internamente genera un ID numérico secuencial y lo convierte a String.
 */
public class NotificacionRepository {
    private final Map<String, Notificacion> notificaciones = new HashMap<>();
    private long currentId = 1;

    /**
     * Guarda una nueva notificación o actualiza una existente.
     * Si notificacion.getId() == null, se genera un nuevo ID (String.valueOf(currentId++)).
     */
    public void guardar(Notificacion notificacion) {
        if (notificacion.getId() == null) {
            notificacion.setId(String.valueOf(currentId++));
        }
        notificaciones.put(notificacion.getId(), notificacion);
    }

    /**
     * Elimina y retorna la notificación con ese ID (String).
     * Devuelve null si no existe.
     */
    public Notificacion eliminar(String id) {
        return notificaciones.remove(id);
    }

    /**
     * Actualiza la notificación con ese ID. Retorna la instancia nueva o null si no existe.
     */
    public Notificacion actualizar(String id, Notificacion actualizada) {
        if (!notificaciones.containsKey(id)) {
            return null;
        }
        actualizada.setId(id);
        notificaciones.put(id, actualizada);
        return actualizada;
    }

    /**
     * Obtiene la notificación por ID (String), o null si no se encuentra.
     */
    public Notificacion obtener(String id) {
        return notificaciones.get(id);
    }

    /**
     * Retorna todas las notificaciones como lista.
     */
    public List<Notificacion> obtenerTodos() {
        return new ArrayList<>(notificaciones.values());
    }
}
