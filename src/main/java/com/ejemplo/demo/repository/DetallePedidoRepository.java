package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.DetallePedido;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetallePedidoRepository {
    private final List<DetallePedido> detallePedidos = new ArrayList<>();

    public void agregar(DetallePedido detallePedido) {
        detallePedidos.add(detallePedido);
    }

    public List<DetallePedido> obtenerTodos() {
        return detallePedidos;
    }

    public Optional<DetallePedido> obtenerPorId(Long id) {
        return detallePedidos.stream()
                .filter(dp -> dp.getId().equals(id))
                .findFirst();
    }

    public boolean eliminarPorId(Long id) {
        return detallePedidos.removeIf(dp -> dp.getId().equals(id));
    }

    public boolean actualizar(DetallePedido detallePedido) {
        Optional<DetallePedido> existente = obtenerPorId(detallePedido.getId());
        if (existente.isPresent()) {
            detallePedidos.remove(existente.get());
            detallePedidos.add(detallePedido);
            return true;
        }
        return false;
    }
}
