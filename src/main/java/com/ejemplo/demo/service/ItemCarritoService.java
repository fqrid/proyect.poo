package com.ejemplo.demo.service;

import com.ejemplo.demo.model.ItemCarrito;
import com.ejemplo.demo.repository.ItemCarritoRepository;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class ItemCarritoService {
    private final ItemCarritoRepository repository;

    public ItemCarritoService(ItemCarritoRepository repository) {
        this.repository = repository;
    }

    public ItemCarrito crear(ItemCarrito item) {
        return repository.save(item);
    }

    public ItemCarrito obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item de carrito no encontrado"));
    }

    public List<ItemCarrito> listar() {
        return repository.findAll();
    }

    public ItemCarrito actualizar(String id, ItemCarrito nuevo) {
        ItemCarrito existente = obtener(id);
        existente.setProductoId(nuevo.getProductoId());
        existente.setCantidad(nuevo.getCantidad());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
