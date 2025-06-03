package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Comentario;
import com.ejemplo.demo.repository.ComentarioRepository;

import java.util.List;

public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    private void validarComentario(Comentario comentario) {
        if (comentario == null) {
            throw new BadParameterException("Comentario no puede estar vacío");
        }
        if (comentario.getTexto() == null || comentario.getTexto().isEmpty()) {
            throw new BadParameterException("El texto del comentario no puede estar vacío");
        }
        if (comentario.getAutor() == null || comentario.getAutor().isEmpty()) {
            throw new BadParameterException("El autor del comentario no puede estar vacío");
        }
    }

    public void guardarComentario(Comentario comentario) {
        this.validarComentario(comentario);
        this.comentarioRepository.agregarComentario(comentario);
    }

    public void eliminarComentario(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el comentario");
        }
        Comentario comentario = this.comentarioRepository.eliminarComentario(Integer.parseInt(id));
        if (comentario == null) {
            throw new NotFoundException("No existe el comentario");
        }
    }

    public void actualizarComentario(String id, Comentario comentarioActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el comentario");
        }
        this.validarComentario(comentarioActualizar);
        Comentario comentario = this.comentarioRepository.actualizarComentario(Integer.parseInt(id), comentarioActualizar);
        if (comentario == null) {
            throw new NotFoundException("No existe el comentario");
        }
    }

    public Comentario obtenerComentario(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el comentario");
        }

        return this.comentarioRepository.obtenerComentario(Integer.parseInt(id));
    }

    public List<Comentario> obtenerComentarios() {
        return this.comentarioRepository.obtenerComentarios();
    }
}
