package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Reseña;
import com.ejemplo.demo.repository.ReseñaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resenas")
public class ReseñaController {

    @Autowired
    private ReseñaRepository reseñaRepository;

    // Obtener todas las reseñas
    @GetMapping
    public List<Reseña> getAllReseñas() {
        return reseñaRepository.findAll();
    }

    // Obtener una reseña por ID
    @GetMapping("/{id}")
    public Optional<Reseña> getReseñaById(@PathVariable Long id) {
        return reseñaRepository.findById(id);
    }

    // Crear una nueva reseña
    @PostMapping
    public Reseña createReseña(@RequestBody Reseña reseña) {
        return reseñaRepository.save(reseña);
    }

    // Actualizar una reseña existente
    @PutMapping("/{id}")
    public Reseña updateReseña(@PathVariable Long id, @RequestBody Reseña detalles) {
        return reseñaRepository.findById(id).map(r -> {
            r.setUsuario(detalles.getUsuario());
            r.setComentario(detalles.getComentario());
            r.setCalificacion(detalles.getCalificacion());
            return reseñaRepository.save(r);
        }).orElseGet(() -> {
            detalles.setId(id);
            return reseñaRepository.save(detalles);
        });
    }

    // Eliminar una reseña
    @DeleteMapping("/{id}")
    public void deleteReseña(@PathVariable Long id) {
        reseñaRepository.deleteById(id);
    }
}
