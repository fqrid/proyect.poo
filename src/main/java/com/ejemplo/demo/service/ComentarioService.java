package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Comentario;
import com.ejemplo.demo.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    public List<Comentario> obtenerTodos() {
        return repository.findAll();
    }

    public Comentario obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Comentario crear(Comentario comentario) {
        return repository.save(comentario);
    }

    public Comentario actualizar(Long id, Comentario comentario) {
        if (repository.existsById(id)) {
            comentario.setId(id);
            return repository.save(comentario);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
