package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Direccion;
import com.ejemplo.demo.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private DireccionRepository direccionRepository;

    // Obtener todas las direcciones
    @GetMapping
    public List<Direccion> getAllDirecciones() {
        return direccionRepository.findAll();
    }

    // Obtener una dirección por ID
    @GetMapping("/{id}")
    public Optional<Direccion> getDireccionById(@PathVariable Long id) {
        return direccionRepository.findById(id);
    }

    // Crear una nueva dirección
    @PostMapping
    public Direccion createDireccion(@RequestBody Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    // Actualizar una dirección existente
    @PutMapping("/{id}")
    public Direccion updateDireccion(@PathVariable Long id, @RequestBody Direccion detalles) {
        return direccionRepository.findById(id).map(dir -> {
            dir.setCalle(detalles.getCalle());
            dir.setCiudad(detalles.getCiudad());
            dir.setPais(detalles.getPais());
            return direccionRepository.save(dir);
        }).orElseGet(() -> {
            detalles.setId(id);
            return direccionRepository.save(detalles);
        });
    }

    // Eliminar una dirección
    @DeleteMapping("/{id}")
    public void deleteDireccion(@PathVariable Long id) {
        direccionRepository.deleteById(id);
    }
}
