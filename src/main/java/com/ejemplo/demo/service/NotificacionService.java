package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.modelo.Notificacion;
import com.ejemplo.demo.repository.NotificacionesRepository;

import java.util.List;

public class NotificacionService {

    private final NotificacionesRepository repo;

    public NotificacionService(NotificacionesRepository repo) {
        this.repo = repo;
    }

    private void validar(Notificacion n) {
        if (n == null) throw new BadParameterException("Notificación inválida");
        if (n.getMensaje() == null || n.getMensaje().isEmpty())
            throw new BadParameterException("Mensaje vacío");
        if (n.getDestinatario() == null || n.getDestinatario().isEmpty())
            throw new BadParameterException("Destinatario vacío");
        if (n.getFecha() == null || n.getFecha().isEmpty())
            throw new BadParameterException("Fecha vacía");
    }

    public void guardar(Notificacion n) {
        validar(n);
        repo.agregar(n);
    }

    public void eliminar(String id) {
        if (id == null) throw new NotFoundException("ID nulo");
        Notificacion eliminado = repo.eliminar(Integer.parseInt(id));
        if (eliminado == null) throw new NotFoundException("No existe la notificación");
    }

    public void actualizar(String id, Notificacion n) {
        validar(n);
        Notificacion actualizado = repo.actualizar(Integer.parseInt(id), n);
        if (actualizado == null) throw new NotFoundException("No existe la notificación");
    }

    public Notificacion obtener(String id) {
        Notificacion n = repo.obtener(Integer.parseInt(id));
        if (n == null) throw new NotFoundException("No existe la notificación");
        return n;
    }

    public List<Notificacion> listar() {
        return repo.obtenerTodos();
    }
}
