package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.ResourceNotFoundException;
import com.ejemplo.demo.model.DetallePedido;
import com.ejemplo.demo.repository.DetallePedidoRepository;
import java.util.List;

public class DetallePedidoService {
    private final DetallePedidoRepository repository;

    public DetallePedidoService(DetallePedidoRepository repository) {
        this.repository = repository;
    }

    public void agregarDetallePedido(DetallePedido detallePedido) {
        repository.agregar(detallePedido);
    }

    public List<DetallePedido> obtenerTodos() {
        return repository.obtenerTodos();
    }

    public DetallePedido obtenerPorId(Long id) {
        return repository.obtenerPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetallePedido no encontrado con id: " + id));
    }

    public void eliminarPorId(Long id) {
        boolean eliminado = repository.eliminarPorId(id);
        if (!eliminado) {
            throw new ResourceNotFoundException("DetallePedido no encontrado con id: " + id);
        }
    }

    public void actualizarDetallePedido(DetallePedido detallePedido) {
        boolean actualizado = repository.actualizar(detallePedido);
        if (!actualizado) {
            throw new ResourceNotFoundException("DetallePedido no encontrado con id: " + detallePedido.getId());
        }
    }
}
