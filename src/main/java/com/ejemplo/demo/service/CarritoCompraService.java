package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.CarritoCompra;
import com.ejemplo.demo.repository.CarritoCompraRepository;

import java.util.List;

public class CarritoCompraService {
    private final CarritoCompraRepository repository;

    public CarritoCompraService(CarritoCompraRepository repository) {
        this.repository = repository;
    }

    private void validar(CarritoCompra entidad) {
        if (entidad == null) {
            throw new BadParameterException("El objeto no puede ser nulo");
        }
    }

    public void guardar(CarritoCompra entidad) {
        validar(entidad);
        repository.agregar(entidad);
    }

    public void eliminar(String id) {
        CarritoCompra entidad = repository.eliminar(Integer.parseInt(id));
        if (entidad == null) {
            throw new NotFoundException("No se encontró el registro");
        }
    }

    public void actualizar(String id, CarritoCompra entidad) {
        validar(entidad);
        CarritoCompra actualizado = repository.actualizar(Integer.parseInt(id), entidad);
        if (actualizado == null) {
            throw new NotFoundException("No se encontró el registro");
        }
    }

    public CarritoCompra obtener(String id) {
        CarritoCompra entidad = repository.obtener(Integer.parseInt(id));
        if (entidad == null) {
            throw new NotFoundException("No se encontró el registro");
        }
        return entidad;
    }

    public List<CarritoCompra> obtenerTodos() {
        return repository.obtenerTodos();
    }
}
