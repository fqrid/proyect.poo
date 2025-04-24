package com.ejemplo.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private Map<Long, Usuario> usuarios = new HashMap<>();
    private long idActual = 1;

    // Crear usuario
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        usuario.setId(idActual++);
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios.values());
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable long id) {
        System.out.println("Recibida solicitud para ID: " + id);
        System.out.println("Usuarios actuales: " + usuarios);
        Usuario usuario = usuarios.get(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un usuario por ID
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuario = usuarios.get(id);
        if (usuario != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setContrasena(usuarioActualizado.getContrasena());
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        if (usuarios.containsKey(id)) {
            usuarios.remove(id);
            return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}