package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.DetallePedido;
import com.ejemplo.demo.repository.DetallePedidoRepository;

import java.util.List;

public class DetallePedidoService {
    private final DetallePedidoRepository repository;

    public DetallePedidoService(DetallePedidoRepository repository) {
        this.repository = repository;
    }

    public DetallePedido crear(DetallePedido detalle) {
        return repository.save(detalle);
    }

    public DetallePedido obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("DetallePedido no encontrado"));
    }

    public List<DetallePedido> listar() {
        return repository.findAll();
    }

    public DetallePedido actualizar(String id, DetallePedido nuevo) {
        DetallePedido existente = obtener(id);
        existente.setPedidoId(nuevo.getPedidoId());
        existente.setProductoId(nuevo.getProductoId());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}