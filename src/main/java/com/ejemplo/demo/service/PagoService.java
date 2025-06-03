package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Pago;
import com.ejemplo.demo.repository.PagoRepository;

import java.util.List;

public class PagoService {
    private final PagoRepository repository;

    public PagoService(PagoRepository repository) {
        this.repository = repository;
    }

    public Pago crear(Pago pago) {
        return repository.save(pago);
    }

    public Pago obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pago no encontrado"));
    }

    public List<Pago> listar() {
        return repository.findAll();
    }

    public Pago actualizar(String id, Pago nuevo) {
        Pago existente = obtener(id);
        existente.setFacturaId(nuevo.getFacturaId());
        existente.setMetodoPagoId(nuevo.getMetodoPagoId());
        existente.setMonto(nuevo.getMonto());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
