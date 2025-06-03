package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.DetallePedido;
import java.util.*;

public class DetallePedidoRepository {
    private final List<DetallePedido> datos = new ArrayList<>();

    public void agregar(DetallePedido detalle) {
        datos.add(detalle);
    }

    public Optional<DetallePedido> obtenerPorId(String id) {
        return datos.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public List<DetallePedido> obtenerTodos() {
        return datos;
    }

    public boolean actualizar(DetallePedido detalle) {
        Optional<DetallePedido> existente = obtenerPorId(detalle.getId());
        if (existente.isPresent()) {
            datos.remove(existente.get());
            datos.add(detalle);
            return true;
        }
        return false;
    }

    public boolean eliminarPorId(String id) {
        return datos.removeIf(d -> d.getId().equals(id));
    }
}
