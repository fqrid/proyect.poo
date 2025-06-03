package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Notificacion;
import java.util.*;

public class NotificacionRepository {
    private final Map<String, Notificacion> datos = new HashMap<>();

    public Notificacion save(Notificacion obj) {
        datos.put(obj.getId(), obj);
        return obj;
    }

    public Optional<Notificacion> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Notificacion> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
