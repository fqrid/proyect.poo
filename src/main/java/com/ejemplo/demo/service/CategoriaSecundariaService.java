package com.ejemplo.demo.service;

import com.ejemplo.demo.model.CategoriaSecundaria;
import com.ejemplo.demo.repository.CategoriaSecundariaRepository;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class CategoriaSecundariaService {
    private final CategoriaSecundariaRepository repository;

    public CategoriaSecundariaService(CategoriaSecundariaRepository repository) {
        this.repository = repository;
    }

    public CategoriaSecundaria crear(CategoriaSecundaria cat) {
        return repository.save(cat);
    }

    public CategoriaSecundaria obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoría secundaria no encontrada"));
    }

    public List<CategoriaSecundaria> listar() {
        return repository.findAll();
    }

    public CategoriaSecundaria actualizar(String id, CategoriaSecundaria nueva) {
        CategoriaSecundaria existente = obtener(id);
        existente.setNombre(nueva.getNombre());
        existente.setCategoriaId(nueva.getCategoriaId());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
