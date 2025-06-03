package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.DetallePedido;

import java.util.*;

public class DetallePedidoRepository {
    private final Map<String, DetallePedido> bd = new HashMap<>();

    public DetallePedido save(DetallePedido detalle) {
        bd.put(detalle.getId(), detalle);
        return detalle;
    }

    public Optional<DetallePedido> findById(String id) {
        return Optional.ofNullable(bd.get(id));
    }

    public List<DetallePedido> findAll() {
        return new ArrayList<>(bd.values());
    }

    public void deleteById(String id) {
        bd.remove(id);
    }
}