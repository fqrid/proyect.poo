package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Pedido;
import java.util.*;

public class PedidoRepository {
    private final Map<String, Pedido> datos = new HashMap<>();

    public Pedido save(Pedido pedido) {
        datos.put(pedido.getId(), pedido);
        return pedido;
    }

    public Optional<Pedido> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<Pedido> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
