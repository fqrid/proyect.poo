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

    public List<Descuento> listar() {
        return repository.findAll();
    }

    public Descuento obtener(String id) {
        return repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new NotFoundException("Descuento no encontrado"));
    }

    public Descuento crear(Descuento d) {
        return repository.save(d);
    }

    public Descuento actualizar(String id, Descuento nuevo) {
        Descuento existente = obtener(id);
        existente.setDescripcion(nuevo.getDescripcion());
        existente.setPorcentaje(nuevo.getPorcentaje());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(Long.parseLong(id));
    }
}