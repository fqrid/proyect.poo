package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Comentario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ComentarioRepository {
    private final List<Comentario> comentarios = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void guardar(Comentario comentario) {
        if (comentario.getId() == null) {
            comentario.setId(autoId.getAndIncrement());
        }
        comentarios.add(comentario);
    }

    public Comentario eliminar(int id) {
        for (int i = 0; i < comentarios.size(); i++) {
            if (comentarios.get(i).getId().equals(id)) {
                return comentarios.remove(i);
            }
        }
        return null;
    }

    public Comentario actualizar(int id, Comentario comentarioNuevo) {
        for (int i = 0; i < comentarios.size(); i++) {
            if (comentarios.get(i).getId().equals(id)) {
                comentarioNuevo.setId(id);
                comentarios.set(i, comentarioNuevo);
                return comentarioNuevo;
            }
        }
        return null;
    }

    public Comentario obtener(int id) {
        for (Comentario comentario : comentarios) {
            if (comentario.getId().equals(id)) {
                return comentario;
            }
        }
        return null;
    }

    public List<Comentario> obtenerTodos() {
        return new ArrayList<>(comentarios);
    }
}