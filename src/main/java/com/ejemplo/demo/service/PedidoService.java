package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.repository.PedidoRepository;
import com.ejemplo.demo.exception.NotFoundException;

import java.util.List;

public class PedidoService {
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> obtenerTodos() {
        return repository.findAll();
    }

    public Pedido obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido no encontrado"));
    }

    public Pedido crear(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido actualizar(Long id, Pedido nuevo) {
        Pedido existente = obtenerPorId(id);
        existente.setEstado(nuevo.getEstado());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }
}
