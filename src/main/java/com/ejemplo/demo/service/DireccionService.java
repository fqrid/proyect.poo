package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Direccion;
import com.ejemplo.demo.repository.DireccionRepository;

import java.util.List;

public class DireccionService {
    private final DireccionRepository repository;

    public DireccionService(DireccionRepository repository) {
        this.repository = repository;
    }

    private void validar(Direccion d) {
        if (d == null) throw new BadParameterException("Direccion inválida");
        if (d.getCiudad() == null || d.getCiudad().isEmpty())
            throw new BadParameterException("Ciudad requerida");
        if (d.getDireccion() == null || d.getDireccion().isEmpty())
            throw new BadParameterException("Direccion requerida");
    }

    public void guardar(Direccion d) {
        validar(d);
        repository.guardar(d);
    }

    public void eliminar(String id) {
        Direccion r = repository.eliminar(Integer.parseInt(id));
        if (r == null) throw new NotFoundException("No existe Dirección");
    }

    public void actualizar(String id, Direccion nuevo) {
        validar(nuevo);
        Direccion actualizado = repository.actualizar(Integer.parseInt(id), nuevo);
        if (actualizado == null) throw new NotFoundException("No existe Dirección");
    }

    public Direccion obtener(String id) {
        Direccion r = repository.obtener(Integer.parseInt(id));
        if (r == null) throw new NotFoundException("No existe Dirección");
        return r;
    }

    public List<Direccion> obtenerTodos() {
        return repository.obtenerTodos();
    }
}