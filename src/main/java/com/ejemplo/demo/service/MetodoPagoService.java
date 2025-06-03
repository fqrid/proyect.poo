package com.ejemplo.demo.service;

import com.ejemplo.demo.model.MetodoPago;
import com.ejemplo.demo.repository.MetodoPagoRepository;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class MetodoPagoService {
    private final MetodoPagoRepository repository;

    public MetodoPagoService(MetodoPagoRepository repository) {
        this.repository = repository;
    }

    public List<MetodoPago> obtenerTodos() {
        return repository.findAll();
    }

    public MetodoPago obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Método de pago no encontrado"));
    }

    public MetodoPago crear(MetodoPago metodo) {
        return repository.save(metodo);
    }

    public MetodoPago actualizar(Long id, MetodoPago nuevo) {
        MetodoPago existente = obtenerPorId(id);
        existente.setTipo(nuevo.getTipo());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }
}
