package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Categoria;
import java.util.*;

public class CategoriaRepository {
    private final Map<String, Categoria> categorias = new HashMap<>();
    private long currentId = 1;

    public Categoria save(Categoria categoria) {
        if (categoria.getId() == null) {
            categoria.setId(String.valueOf(currentId++));
        }
        categorias.put(categoria.getId(), categoria);
        return categoria;
    }

    public Optional<Categoria> findById(String id) {
        return Optional.ofNullable(categorias.get(id));
    }

    public List<Categoria> findAll() {
        return new ArrayList<>(categorias.values());
    }

    public void deleteById(String id) {
        categorias.remove(id);
    }
}