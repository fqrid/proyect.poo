package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Notificacion;
import com.ejemplo.demo.repository.NotificacionRepository;

import java.util.List;

public class NotificacionService {
    private final NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    private void validar(Notificacion n) {
        if (n == null) throw new BadParameterException("Notificación inválida");
        if (n.getMensaje() == null || n.getMensaje().isEmpty())
            throw new BadParameterException("Mensaje requerido");
    }

    public void guardar(Notificacion n) {
        validar(n);
        repository.guardar(n);
    }

    public void eliminar(String id) {
        Notificacion r = repository.eliminar(id);
        if (r == null) throw new NotFoundException("No existe Notificación con ID: " + id);
    }

    public void actualizar(String id, Notificacion nuevo) {
        validar(nuevo);
        Notificacion actualizado = repository.actualizar(id, nuevo);
        if (actualizado == null) throw new NotFoundException("No existe Notificación con ID: " + id);
    }

    public Notificacion obtener(String id) {
        Notificacion r = repository.obtener(id);
        if (r == null) throw new NotFoundException("No existe Notificación con ID: " + id);
        return r;
    }

    public List<Notificacion> obtenerTodos() {
        return repository.obtenerTodos();
    }
}
