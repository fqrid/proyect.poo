package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.repository.ProductoRepository;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class ProductoService {

    private final ProductoRepository repository = new ProductoRepository();

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto con ID " + id + " no encontrado"));
    }

    public Producto crear(Producto producto) {
        return repository.save(producto);
    }

    public Producto actualizar(Long id, Producto nuevo) {
        Producto existente = obtenerPorId(id);
        existente.setNombre(nuevo.getNombre());
        // otros setters...
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        obtenerPorId(id); // para lanzar error si no existe
        repository.deleteById(id);
    }
}
