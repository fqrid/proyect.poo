package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.DetalleFactura;
import com.ejemplo.demo.repository.DetalleFacturaRepository;

import java.util.List;

public class DetalleFacturaService {
    private final DetalleFacturaRepository repository;

    public DetalleFacturaService(DetalleFacturaRepository repository) {
        this.repository = repository;
    }

    public List<DetalleFactura> obtenerTodos() {
        return repository.obtenerTodos();
    }

    public DetalleFactura obtenerPorId(Long id) {
        return repository.obtenerPorId(id)
                .orElseThrow(() -> new NotFoundException("DetalleFactura no encontrado con id: " + id));
    }

    public void agregar(DetalleFactura detalleFactura) {
        repository.agregar(detalleFactura);
    }

    public void eliminarPorId(Long id) {
        boolean eliminado = repository.eliminarPorId(id);
        if (!eliminado) {
            throw new NotFoundException("DetalleFactura no encontrado con id: " + id);
        }
    }

    public void actualizar(DetalleFactura detalleFactura) {
        boolean actualizado = repository.actualizar(detalleFactura);
        if (!actualizado) {
            throw new NotFoundException("DetalleFactura no encontrado con id: " + detalleFactura.getId());
        }
    }
}