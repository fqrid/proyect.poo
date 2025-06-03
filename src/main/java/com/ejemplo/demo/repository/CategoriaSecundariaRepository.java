package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.CategoriaSecundaria;
import java.util.*;

public class CategoriaSecundariaRepository {
    private final Map<String, CategoriaSecundaria> datos = new HashMap<>();

    public CategoriaSecundaria save(CategoriaSecundaria categoria) {
        datos.put(categoria.getId(), categoria);
        return categoria;
    }

    public Optional<CategoriaSecundaria> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<CategoriaSecundaria> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
