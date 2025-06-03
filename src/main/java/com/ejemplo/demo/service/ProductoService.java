package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.repository.ProductoRepository;

import java.util.List;

public class ProductoService {
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public Producto crear(Producto producto) {
        return repository.save(producto);
    }

    public Producto obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto actualizar(String id, Producto nuevo) {
        Producto existente = obtener(id);
        existente.setNombre(nuevo.getNombre());
        existente.setPrecio(nuevo.getPrecio());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
