package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Comentario;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ComentarioRepository {
    private final ArrayList<Comentario> comentarios = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarComentario(Comentario comentario) {
        comentario.setId((long) this.autoId.getAndIncrement());
        this.comentarios.add(comentario);
    }

    public Comentario eliminarComentario(int id) {
        Comentario comentario = null;
        for (int i = 0; i < comentarios.size(); i++) {
            if (comentarios.get(i).getId() == id) {
                comentario = comentarios.remove(i);
                break;
            }
        }
        return comentario;
    }

    public Comentario actualizarComentario(int id, Comentario comentarioActualizado) {
        Comentario comentario = null;
        for (int i = 0; i < comentarios.size(); i++) {
            if (comentarios.get(i).getId() == id) {
                comentarios.set(i, comentarioActualizado);
                comentario = comentarioActualizado;
                break;
            }
        }
        return comentario;
    }

    public Comentario obtenerComentario(int id) {
        for (Comentario comentario : comentarios) {
            if (comentario.getId() == id) {
                return comentario;
            }
        }
        return null;
    }

    public ArrayList<Comentario> obtenerComentarios() {
        return this.comentarios;
    }
}
