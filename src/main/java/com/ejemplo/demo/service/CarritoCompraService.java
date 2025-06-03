package com.ejemplo.demo.service;

import com.ejemplo.demo.model.CarritoCompra;
import com.ejemplo.demo.repository.CarritoCompraRepository;

import java.util.List;

public class CarritoCompraService {

    private final CarritoCompraRepository repository;

    public CarritoCompraService(CarritoCompraRepository repository) {
        this.repository = repository;
    }

    public void crear(CarritoCompra carrito) {
        repository.save(carrito);
    }

    public CarritoCompra obtener(String id) {
        return repository.findById(id);
    }

    public void actualizar(String id, CarritoCompra actualizado) {
        repository.update(id, actualizado);
    }

    public void eliminar(String id) {
        repository.deleteById(id);
    }

    public List<CarritoCompra> listar() {
        return repository.findAll();
    }
}
