package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Usuario;
import java.util.*;

public class UsuarioRepository {
    private final Map<Long, Usuario> usuarios = new HashMap<>();
    private long currentId = 1;

    public Usuario save(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(currentId++);
        }
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public Optional<Usuario> findById(Long id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    public void deleteById(Long id) {
        usuarios.remove(id);
    }
}