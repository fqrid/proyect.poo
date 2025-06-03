package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Usuario;
import java.util.*;

public class UsuarioRepository {
    private final Map<String, Usuario> datos = new HashMap<>();

    public Usuario save(Usuario usuario) {
        datos.put(usuario.getId(), usuario);
        return usuario;
    }

    public Optional<Usuario> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
