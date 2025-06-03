package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.ItemCarrito;
import com.ejemplo.demo.repository.ItemCarritoRepository;

import java.util.List;

public class ItemCarritoService {

    private final ItemCarritoRepository repository;

    public ItemCarritoService(ItemCarritoRepository repository) {
        this.repository = repository;
    }

    public List<ItemCarrito> obtenerTodos() {
        return repository.findAll();
    }

    public ItemCarrito obtenerPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item no encontrado con ID: " + id));
    }

    public ItemCarrito crear(ItemCarrito item) {
        return repository.save(item);
    }

    public ItemCarrito actualizar(String id, ItemCarrito nuevo) {
        ItemCarrito existente = obtenerPorId(id);
        existente.setCantidad(nuevo.getCantidad());
        existente.setProductoId(nuevo.getProductoId());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }
}