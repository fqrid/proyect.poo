package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Rol;
import com.ejemplo.demo.repository.RolRepository;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class RolService {
    private final RolRepository repository;

    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    public List<Rol> obtenerTodos() {
        return repository.findAll();
    }

    public Rol obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rol no encontrado"));
    }

    public Rol crear(Rol rol) {
        return repository.save(rol);
    }

    public Rol actualizar(Long id, Rol nuevo) {
        Rol existente = obtenerPorId(id);
        existente.setNombre(nuevo.getNombre());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }
}
