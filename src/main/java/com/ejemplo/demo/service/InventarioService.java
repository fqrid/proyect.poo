package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Inventario;
import com.ejemplo.demo.repository.InventarioRepository;

import java.util.List;

public class InventarioService {
    private final InventarioRepository repository;

    public InventarioService(InventarioRepository repository) {
        this.repository = repository;
    }

    public Inventario crear(Inventario inventario) {
        return repository.save(inventario);
    }

    public Inventario obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Inventario no encontrado"));
    }

    public List<Inventario> listar() {
        return repository.findAll();
    }

    public Inventario actualizar(String id, Inventario nuevo) {
        Inventario existente = obtener(id);
        existente.setProductoId(nuevo.getProductoId());
        existente.setCantidad(nuevo.getCantidad());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
