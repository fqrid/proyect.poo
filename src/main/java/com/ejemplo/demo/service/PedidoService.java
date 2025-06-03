package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.repository.PedidoRepository;

import java.util.List;

public class PedidoService {
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido crear(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido obtener(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido no encontrado"));
    }

    public List<Pedido> listar() {
        return repository.findAll();
    }

    public Pedido actualizar(String id, Pedido nuevo) {
        Pedido existente = obtener(id);
        existente.setClienteId(nuevo.getClienteId());
        existente.setFechaPedido(nuevo.getFechaPedido());
        return repository.save(existente);
    }

    public void eliminar(String id) {
        obtener(id);
        repository.deleteById(id);
    }
}
