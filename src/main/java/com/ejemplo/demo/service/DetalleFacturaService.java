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

    public DetalleFactura crear(DetalleFactura detalle) {
        repository.agregar(detalle);
        return detalle;
    }

    public DetalleFactura obtener(String id) {
        return repository.obtenerPorId(id)
                .orElseThrow(() -> new NotFoundException("DetalleFactura no encontrado"));
    }

    public List<DetalleFactura> listar() {
        return repository.obtenerTodos();
    }

    public DetalleFactura actualizar(String id, DetalleFactura nuevo) {
        DetalleFactura existente = obtener(id);
        existente.setCantidad(nuevo.getCantidad());
        existente.setPrecioUnitario(nuevo.getPrecioUnitario());
        existente.setFacturaId(nuevo.getFacturaId());
        existente.setProductoId(nuevo.getProductoId());
        repository.actualizar(existente);
        return existente;
    }

    public void eliminar(String id) {
        boolean eliminado = repository.eliminarPorId(id);
        if (!eliminado) throw new NotFoundException("DetalleFactura no encontrado");
    }
}