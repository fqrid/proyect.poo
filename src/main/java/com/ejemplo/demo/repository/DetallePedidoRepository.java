package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.DetallePedido;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DetallePedidoRepository {
    private final List<DetallePedido> detalles = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void guardar(DetallePedido detalle) {
        if (detalle.getId() == null) {
            detalle.setId(autoId.getAndIncrement());
        }
        detalles.add(detalle);
    }

    public DetallePedido eliminar(int id) {
        for (int i = 0; i < detalles.size(); i++) {
            if (detalles.get(i).getId().equals(id)) {
                return detalles.remove(i);
            }
        }
        return null;
    }

    public DetallePedido actualizar(int id, DetallePedido nuevo) {
        for (int i = 0; i < detalles.size(); i++) {
            if (detalles.get(i).getId().equals(id)) {
                nuevo.setId(id);
                detalles.set(i, nuevo);
                return nuevo;
            }
        }
        return null;
    }

    public DetallePedido obtener(int id) {
        for (DetallePedido d : detalles) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public List<DetallePedido> obtenerTodos() {
        return new ArrayList<>(detalles);
    }
}