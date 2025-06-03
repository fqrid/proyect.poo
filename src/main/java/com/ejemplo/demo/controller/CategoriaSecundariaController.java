package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.CategoriaSecundaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias-secundarias")
public class CategoriaSecundariaController {

    // Obtener todas las categorías secundarias
    @GetMapping
    public List<CategoriaSecundaria> getAllCategoriasSecundarias() {
        return categoriaSecundariaRepository.findAll();
    }

    // Obtener una categoría secundaria por ID
    @GetMapping("/{id}")
    public Optional<CategoriaSecundaria> getCategoriaSecundariaById(@PathVariable Long id) {
        return categoriaSecundariaRepository.findById(id);
    }

    // Crear una nueva categoría secundaria
    @PostMapping
    public CategoriaSecundaria createCategoriaSecundaria(@RequestBody CategoriaSecundaria categoria) {
        return categoriaSecundariaRepository.save(categoria);
    }

    // Actualizar una categoría secundaria existente
    @PutMapping("/{id}")
    public CategoriaSecundaria updateCategoriaSecundaria(@PathVariable Long id,
            @RequestBody CategoriaSecundaria detalles) {
        return categoriaSecundariaRepository.findById(id).map(cat -> {
            cat.setNombre(detalles.getNombre());
            cat.setCategoriaPrincipalId(detalles.getCategoriaPrincipalId());
            return categoriaSecundariaRepository.save(cat);
        }).orElseGet(() -> {
            detalles.setId(id);
            return categoriaSecundariaRepository.save(detalles);
        });
    }

    // Eliminar una categoría secundaria
    @DeleteMapping("/{id}")
    public void deleteCategoriaSecundaria(@PathVariable Long id) {
        categoriaSecundariaRepository.deleteById(id);
    }
}
