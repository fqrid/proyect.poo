package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario crear(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario actualizar(String id, Usuario nuevo) {
        Usuario existente = obtener(id);
        existente.setNombre(nuevo.getNombre());
        existente.setEmail(nuevo.getEmail());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
