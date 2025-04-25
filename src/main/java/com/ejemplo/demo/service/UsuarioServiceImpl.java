package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Usuario crear(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        Optional<Usuario> existente = repository.findById(id);
        if (existente.isPresent()) {
            Usuario actualizado = existente.get();
            actualizado.setNombre(usuario.getNombre());
            actualizado.setCorreo(usuario.getCorreo());
            return repository.save(actualizado);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
