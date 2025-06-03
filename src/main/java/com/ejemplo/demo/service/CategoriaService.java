package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Categoria;
import com.ejemplo.demo.repository.CategoriaRepository;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria crear(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
    }

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria actualizar(String id, Categoria nueva) {
        Categoria existente = obtener(id);
        existente.setNombre(nueva.getNombre());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
