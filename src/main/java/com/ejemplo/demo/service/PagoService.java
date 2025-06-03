package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Pago;
import com.ejemplo.demo.repository.PagoRepository;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class PagoService {
    private final PagoRepository repository;

    public PagoService(PagoRepository repository) {
        this.repository = repository;
    }

    public List<Pago> obtenerTodos() {
        return repository.findAll();
    }

    public Pago obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pago no encontrado"));
    }

    public Pago crear(Pago pago) {
        return repository.save(pago);
    }

    public Pago actualizar(Long id, Pago nuevo) {
        Pago existente = obtenerPorId(id);
        existente.setMonto(nuevo.getMonto());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }
}
