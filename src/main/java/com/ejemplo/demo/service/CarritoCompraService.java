package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.CarritoCompra;
import com.ejemplo.demo.repository.CarritoCompraRepository;

import java.util.List;

public class CarritoCompraService {
    private final CarritoCompraRepository repository;

    public CarritoCompraService(CarritoCompraRepository repository) {
        this.repository = repository;
    }

    public CarritoCompra crear(CarritoCompra carrito) {
        return repository.save(carrito);
    }

    public CarritoCompra obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Carrito no encontrado"));
    }

    public List<CarritoCompra> listar() {
        return repository.findAll();
    }

    public CarritoCompra actualizar(String id, CarritoCompra nuevo) {
        CarritoCompra existente = obtener(id);
        existente.setClienteId(nuevo.getClienteId());
        existente.setProductos(nuevo.getProductos());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}