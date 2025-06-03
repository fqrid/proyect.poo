package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Comentario;
import java.util.*;

public class ComentarioRepository {
    private final Map<String, Comentario> datos = new HashMap<>();

    public Comentario save(Comentario comentario) {
        datos.put(comentario.getId(), comentario);
        return comentario;
    }

    public Optional<Comentario> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Comentario> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
