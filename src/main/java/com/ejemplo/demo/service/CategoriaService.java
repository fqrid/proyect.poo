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

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró la categoría con id: " + id));
    }

    public Categoria crear(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria actualizar(String id, Categoria nuevo) {
        Categoria existente = obtener(id);
        existente.setNombre(nuevo.getNombre());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id); // Esto lanza excepción si no existe
        repository.deleteById(id);
    }
}
