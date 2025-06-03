package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.DetalleFactura;
import java.util.*;

public class DetalleFacturaRepository {
    private final List<DetalleFactura> datos = new ArrayList<>();

    public void agregar(DetalleFactura detalle) {
        datos.add(detalle);
    }

    public Optional<DetalleFactura> obtenerPorId(String id) {
        return datos.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public List<DetalleFactura> obtenerTodos() {
        return datos;
    }

    public boolean actualizar(DetalleFactura detalle) {
        Optional<DetalleFactura> existente = obtenerPorId(detalle.getId());
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
