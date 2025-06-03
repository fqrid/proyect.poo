package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Factura;
import com.ejemplo.demo.repository.FacturaRepository;

import java.util.List;

public class FacturaService {
    private final FacturaRepository repository;

    public FacturaService(FacturaRepository repository) {
        this.repository = repository;
    }

    public Factura crear(Factura factura) {
        return repository.save(factura);
    }

    public Factura obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Factura no encontrada"));
    }

    public List<Factura> listar() {
        return repository.findAll();
    }

    public Factura actualizar(String id, Factura nuevo) {
        Factura existente = obtener(id);
        existente.setClienteId(nuevo.getClienteId());
        existente.setFecha(nuevo.getFecha());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
