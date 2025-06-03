package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Resena;
import com.ejemplo.demo.repository.ResenaRepository;

import java.util.List;

public class ResenaService {
    private final ResenaRepository repository;

    public ResenaService(ResenaRepository repository) {
        this.repository = repository;
    }

    public Resena crear(Resena resena) {
        return repository.save(resena);
    }

    public Resena obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reseña no encontrada"));
    }

    public List<Resena> listar() {
        return repository.findAll();
    }

    public Resena actualizar(String id, Resena nuevo) {
        Resena existente = obtener(id);
        existente.setComentario(nuevo.getComentario());
        existente.setCalificacion(nuevo.getCalificacion());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
