package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Categoria;
import com.ejemplo.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> obtenerTodos() {
        return repository.findAll();
    }

    public Categoria obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Categoria crear(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria actualizar(Long id, Categoria categoria) {
        if (repository.existsById(id)) {
            categoria.setId(id);
            return repository.save(categoria);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}