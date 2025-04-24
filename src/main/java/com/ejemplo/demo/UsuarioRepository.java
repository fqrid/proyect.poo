package com.ejemplo.demo;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UsuarioRepository {
    private final Map<Long, Usuario> usuarios = new HashMap<>();
    private long currentId = 1;

    public Usuario crear(String nombre, String correo, String contrasena) {
        Usuario usuario = new Usuario(currentId, nombre, correo, contrasena);
        usuarios.put(currentId++, usuario);
        return usuario;
    }

    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios.values());
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    public Usuario actualizar(Long id, String nombre, String correo) {
        Usuario usuario = usuarios.get(id);
        if (usuario != null) {
            usuario.setNombre(nombre);
            usuario.setCorreo(correo);
        }
        return usuario;
    }

    public boolean eliminar(Long id) {
        return usuarios.remove(id) != null;
    }
}
