package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Rol;
import com.ejemplo.demo.repository.RolRepository;

import java.util.List;

public class RolService {
    private final RolRepository repository;

    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    public Rol crear(Rol rol) {
        return repository.save(rol);
    }

    public Rol obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rol no encontrado"));
    }

    public List<Rol> listar() {
        return repository.findAll();
    }

    public Rol actualizar(String id, Rol nuevo) {
        Rol existente = obtener(id);
        existente.setNombre(nuevo.getNombre());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
