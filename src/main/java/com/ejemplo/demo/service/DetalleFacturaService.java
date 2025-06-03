package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.ResourceNotFoundException;
import com.ejemplo.demo.model.DetalleFactura;
import com.ejemplo.demo.repository.DetalleFacturaRepository;
import java.util.List;

public class DetalleFacturaService {
    private final DetalleFacturaRepository repository;

    public DetalleFacturaService(DetalleFacturaRepository repository) {
        this.repository = repository;
    }

    public void agregarDetalleFactura(DetalleFactura detalleFactura) {
        repository.agregar(detalleFactura);
    }

    public List<DetalleFactura> obtenerTodos() {
        return repository.obtenerTodos();
    }

    public DetalleFactura obtenerPorId(Long id) {
        return repository.obtenerPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleFactura no encontrado con id: " + id));
    }

    public void eliminarPorId(Long id) {
        boolean eliminado = repository.eliminarPorId(id);
        if (!eliminado) {
            throw new ResourceNotFoundException("DetalleFactura no encontrado con id: " + id);
        }
    }

    public void actualizarDetalleFactura(DetalleFactura detalleFactura) {
        boolean actualizado = repository.actualizar(detalleFactura);
        if (!actualizado) {
            throw new ResourceNotFoundException("DetalleFactura no encontrado con id: " + detalleFactura.getId());
        }
    }
}
