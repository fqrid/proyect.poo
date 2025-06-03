package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Descuento;
import com.ejemplo.demo.repository.DescuentoRepository;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class DescuentoService {

    private final DescuentoRepository repository;

    public DescuentoService(DescuentoRepository repository) {
        this.repository = repository;
    }

    public List<Descuento> obtenerTodos() {
        return repository.findAll();
    }

    public Descuento obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Descuento no encontrado"));
    }

    public Descuento crear(Descuento d) {
        return repository.save(d);
    }

    public Descuento actualizar(Long id, Descuento nuevo) {
        Descuento existente = obtenerPorId(id);
        existente.setDescripcion(nuevo.getDescripcion());
        existente.setPorcentaje(nuevo.getPorcentaje());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }
}