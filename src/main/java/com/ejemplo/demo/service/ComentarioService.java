package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Comentario;
import com.ejemplo.demo.repository.ComentarioRepository;
import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class ComentarioService {

    private final ComentarioRepository repository;

    public ComentarioService(ComentarioRepository repository) {
        this.repository = repository;
    }

    private void validar(Comentario comentario) {
        if (comentario == null) throw new BadParameterException("Comentario no puede ser null");
        if (comentario.getTexto() == null || comentario.getTexto().isEmpty()) {
            throw new BadParameterException("Texto requerido");
        }
    }

    // renombrado de guardar → crear
    public void crear(Comentario comentario) {
        validar(comentario);
        repository.guardar(comentario);
    }

    public void eliminar(String id) {
        Comentario eliminado = repository.eliminar(Integer.parseInt(id));
        if (eliminado == null) {
            throw new NotFoundException("Comentario no encontrado");
        }
    }

    public void actualizar(String id, Comentario nuevo) {
        validar(nuevo);
        Comentario actualizado = repository.actualizar(Integer.parseInt(id), nuevo);
        if (actualizado == null) {
            throw new NotFoundException("Comentario no encontrado");
        }
    }

    public Comentario obtener(String id) {
        Comentario comentario = repository.obtener(Integer.parseInt(id));
        if (comentario == null) {
            throw new NotFoundException("Comentario no encontrado");
        }
        return comentario;
    }

    // renombrado de obtenerTodos → listar
    public List<Comentario> listar() {
        return repository.obtenerTodos();
    }
}