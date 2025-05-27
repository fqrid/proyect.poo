package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resenas")
public class ReseñaController {

    @Autowired
    private ReseñaService reseñaService;

    // Listar todas las reseñas
    @GetMapping
    public List<Reseña> getAllResenas() {
        return reseñaService.findAll();
    }

    // Obtener reseña por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reseña> getResenaById(@PathVariable Long id) {
        Optional<Reseña> reseña = reseñaService.findById(id);
        if (reseña.isPresent()) {
            return ResponseEntity.ok(reseña.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva reseña
    @PostMapping
    public Reseña createResena(@RequestBody Reseña reseña) {
        return reseñaService.save(reseña);
    }

    // Actualizar una reseña existente
    @PutMapping("/{id}")
    public ResponseEntity<Reseña> updateResena(@PathVariable Long id, @RequestBody Reseña reseñaDetails) {
        Optional<Reseña> reseñaOptional = reseñaService.findById(id);

        if (reseñaOptional.isPresent()) {
            Reseña reseña = reseñaOptional.get();
            // Actualizar campos según tu modelo, ejemplo:
            reseña.setTitulo(reseñaDetails.getTitulo());
            reseña.setComentario(reseñaDetails.getComentario());
            reseña.setCalificacion(reseñaDetails.getCalificacion());
            reseña.setUsuario(reseñaDetails.getUsuario());
            reseña.setProducto(reseñaDetails.getProducto());
            // Guardar cambios
            Reseña updatedResena = reseñaService.save(reseña);
            return ResponseEntity.ok(updatedResena);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una reseña
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResena(@PathVariable Long id) {
        Optional<Reseña> reseñaOptional = reseñaService.findById(id);
        if (reseñaOptional.isPresent()) {
            reseñaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
