package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Inventario;
import com.ejemplo.demo.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioRepository inventarioRepository;

    // Obtener todos los registros de inventario
    @GetMapping
    public List<Inventario> getAllInventario() {
        return inventarioRepository.findAll();
    }

    // Obtener un registro de inventario por ID
    @GetMapping("/{id}")
    public Optional<Inventario> getInventarioById(@PathVariable Long id) {
        return inventarioRepository.findById(id);
    }

    // Crear un nuevo registro de inventario
    @PostMapping
    public Inventario createInventario(@RequestBody Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    // Actualizar un registro de inventario existente
    @PutMapping("/{id}")
    public Inventario updateInventario(@PathVariable Long id, @RequestBody Inventario detalles) {
        return inventarioRepository.findById(id).map(inv -> {
            inv.setProducto(detalles.getProducto());
            inv.setCantidad(detalles.getCantidad());
            return inventarioRepository.save(inv);
        }).orElseGet(() -> {
            detalles.setId(id);
            return inventarioRepository.save(detalles);
        });
    }

    // Eliminar un registro de inventario
    @DeleteMapping("/{id}")
    public void deleteInventario(@PathVariable Long id) {
        inventarioRepository.deleteById(id);
    }
}
