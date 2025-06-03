package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Resena;
import com.ejemplo.demo.repository.ResenaRepository;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class ResenaService {
    private final ResenaRepository repository;

    public ResenaService(ResenaRepository repository) {
        this.repository = repository;
    }

    public List<Resena> obtenerTodos() {
        return repository.findAll();
    }

    public Resena obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reseña no encontrada"));
    }

    public Resena crear(Resena resena) {
        return repository.save(resena);
    }

    public Resena actualizar(Long id, Resena nuevo) {
        Resena existente = obtenerPorId(id);
        existente.setTexto(nuevo.getTexto());
        existente.setCalificacion(nuevo.getCalificacion());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }
}
