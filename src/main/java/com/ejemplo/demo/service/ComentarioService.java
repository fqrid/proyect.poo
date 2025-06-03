package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Comentario;
import com.ejemplo.demo.repository.ComentarioRepository;

import java.util.List;

public class ComentarioService {
    private final ComentarioRepository repository;

    public ComentarioService(ComentarioRepository repository) {
        this.repository = repository;
    }

    public Comentario crear(Comentario comentario) {
        return repository.save(comentario);
    }

    public Comentario obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Comentario no encontrado"));
    }

    public List<Comentario> listar() {
        return repository.findAll();
    }

    public Comentario actualizar(String id, Comentario nuevo) {
        Comentario existente = obtener(id);
        existente.setProductoId(nuevo.getProductoId());
        existente.setTexto(nuevo.getTexto());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}