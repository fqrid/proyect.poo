package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Rol;
import com.ejemplo.demo.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    // Obtener todos los roles
    @GetMapping
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    // Obtener un rol por ID
    @GetMapping("/{id}")
    public Optional<Rol> getRolById(@PathVariable Long id) {
        return rolRepository.findById(id);
    }

    // Crear un nuevo rol
    @PostMapping
    public Rol createRol(@RequestBody Rol rol) {
        return rolRepository.save(rol);
    }

    // Actualizar un rol existente
    @PutMapping("/{id}")
    public Rol updateRol(@PathVariable Long id, @RequestBody Rol detalles) {
        return rolRepository.findById(id).map(r -> {
            r.setNombre(detalles.getNombre());
            return rolRepository.save(r);
        }).orElseGet(() -> {
            detalles.setId(id);
            return rolRepository.save(detalles);
        });
    }

    // Eliminar un rol
    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable Long id) {
        rolRepository.deleteById(id);
    }
}
