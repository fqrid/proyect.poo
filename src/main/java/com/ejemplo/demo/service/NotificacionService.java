package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Notificacion;
import com.ejemplo.demo.repository.NotificacionRepository;

import java.util.List;

public class NotificacionService {
    private final NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    public Notificacion crear(Notificacion notificacion) {
        return repository.save(notificacion);
    }

    public Notificacion obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Notificación no encontrada"));
    }

    public List<Notificacion> listar() {
        return repository.findAll();
    }

    public Notificacion actualizar(String id, Notificacion nuevo) {
        Notificacion existente = obtener(id);
        existente.setMensaje(nuevo.getMensaje());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
