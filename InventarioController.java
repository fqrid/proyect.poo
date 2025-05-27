package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // Listar todos los inventarios
    @GetMapping
    public List<Inventario> getAllInventarios() {
        return inventarioService.findAll();
    }

    // Obtener inventario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable Long id) {
        Optional<Inventario> inventario = inventarioService.findById(id);
        if (inventario.isPresent()) {
            return ResponseEntity.ok(inventario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo inventario
    @PostMapping
    public Inventario createInventario(@RequestBody Inventario inventario) {
        return inventarioService.save(inventario);
    }

    // Actualizar inventario existente
    @PutMapping("/{id}")
    public ResponseEntity<Inventario> updateInventario(@PathVariable Long id, @RequestBody Inventario inventarioDetails) {
        Optional<Inventario> inventarioOptional = inventarioService.findById(id);

        if (inventarioOptional.isPresent()) {
            Inventario inventario = inventarioOptional.get();
            // Aquí actualizas los campos, ejemplo:
            inventario.setProducto(inventarioDetails.getProducto());
            inventario.setCantidad(inventarioDetails.getCantidad());
            inventario.setUbicacion(inventarioDetails.getUbicacion());
            // Guarda cambios
            Inventario updatedInventario = inventarioService.save(inventario);
            return ResponseEntity.ok(updatedInventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar inventario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id) {
        Optional<Inventario> inventarioOptional = inventarioService.findById(id);
        if (inventarioOptional.isPresent()) {
            inventarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
