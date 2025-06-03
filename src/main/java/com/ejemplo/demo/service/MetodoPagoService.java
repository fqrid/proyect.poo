package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.MetodoPago;
import com.ejemplo.demo.repository.MetodoPagoRepository;

import java.util.List;

public class MetodoPagoService {
    private final MetodoPagoRepository repository;

    public MetodoPagoService(MetodoPagoRepository repository) {
        this.repository = repository;
    }

    public MetodoPago crear(MetodoPago metodo) {
        return repository.save(metodo);
    }

    public MetodoPago obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Método de pago no encontrado"));
    }

    public List<MetodoPago> listar() {
        return repository.findAll();
    }

    public MetodoPago actualizar(String id, MetodoPago nuevo) {
        MetodoPago existente = obtener(id);
        existente.setNombre(nuevo.getNombre());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
