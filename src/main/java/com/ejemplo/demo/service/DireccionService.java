package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Direccion;
import com.ejemplo.demo.repository.DireccionRepository;

import java.util.List;

public class DireccionService {
    private final DireccionRepository repository;

    public DireccionService(DireccionRepository repository) {
        this.repository = repository;
    }

    public Direccion crear(Direccion direccion) {
        return repository.save(direccion);
    }

    public Direccion obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dirección no encontrada"));
    }

    public List<Direccion> listar() {
        return repository.findAll();
    }

    public Direccion actualizar(String id, Direccion nueva) {
        Direccion existente = obtener(id);
        existente.setCalle(nueva.getCalle());
        existente.setCiudad(nueva.getCiudad());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}