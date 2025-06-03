package com.ejemplo.demo.service;

import com.ejemplo.demo.model.CategoriaSecundaria;
import com.ejemplo.demo.repository.CategoriaSecundariaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CategoriaSecundariaService {

    private final CategoriaSecundariaRepository repositorio;

    public CategoriaSecundariaService(CategoriaSecundariaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void crear(CategoriaSecundaria categoria) {
        repositorio.save(categoria);
    }

    public CategoriaSecundaria obtener(String id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Categoría secundaria no encontrada"));
    }

    public void actualizar(String id, CategoriaSecundaria nuevaCategoria) {
        CategoriaSecundaria existente = obtener(id);
        nuevaCategoria.setId(id);
        repositorio.save(nuevaCategoria);
    }

    public void eliminar(String id) {
        repositorio.deleteById(id);
    }

    public List<CategoriaSecundaria> listar() {
        return repositorio.findAll();
    }
}
