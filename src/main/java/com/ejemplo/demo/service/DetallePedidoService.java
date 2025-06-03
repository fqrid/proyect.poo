package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.DetallePedido;
import com.ejemplo.demo.repository.DetallePedidoRepository;

import java.util.List;

public class DetallePedidoService {
    private final DetallePedidoRepository repository;

    public DetallePedidoService(DetallePedidoRepository repository) {
        this.repository = repository;
    }

    private void validar(DetallePedido d) {
        if (d == null) throw new BadParameterException("DetallePedido inválido");
        if (d.getProducto() == null) throw new BadParameterException("Debe tener producto");
        if (d.getCantidad() <= 0) throw new BadParameterException("Cantidad debe ser mayor que cero");
    }

    public void guardar(DetallePedido d) {
        validar(d);
        repository.guardar(d);
    }

    public void eliminar(String id) {
        DetallePedido r = repository.eliminar(Integer.parseInt(id));
        if (r == null) throw new NotFoundException("No existe DetallePedido");
    }

    public void actualizar(String id, DetallePedido nuevo) {
        validar(nuevo);
        DetallePedido actualizado = repository.actualizar(Integer.parseInt(id), nuevo);
        if (actualizado == null) throw new NotFoundException("No existe DetallePedido");
    }

    public DetallePedido obtener(String id) {
        DetallePedido r = repository.obtener(Integer.parseInt(id));
        if (r == null) throw new NotFoundException("No existe DetallePedido");
        return r;
    }

    public List<DetallePedido> obtenerTodos() {
        return repository.obtenerTodos();
    }
}