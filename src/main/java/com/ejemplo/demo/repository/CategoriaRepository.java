package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Categoria;
import java.util.*;

public class CategoriaRepository {
    private final Map<String, Categoria> datos = new HashMap<>();

    public Categoria save(Categoria categoria) {
        datos.put(categoria.getId(), categoria);
        return categoria;
    }

    public Optional<Categoria> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Categoria> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
