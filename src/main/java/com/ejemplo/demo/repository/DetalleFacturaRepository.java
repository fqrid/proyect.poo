package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.DetalleFactura;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetalleFacturaRepository {
    private final List<DetalleFactura> detalleFacturas = new ArrayList<>();

    public void agregar(DetalleFactura detalleFactura) {
        detalleFacturas.add(detalleFactura);
    }

    public List<DetalleFactura> obtenerTodos() {
        return detalleFacturas;
    }

    public Optional<DetalleFactura> obtenerPorId(Long id) {
        return detalleFacturas.stream()
                .filter(df -> df.getId().equals(id))
                .findFirst();
    }

    public boolean eliminarPorId(Long id) {
        return detalleFacturas.removeIf(df -> df.getId().equals(id));
    }

    public boolean actualizar(DetalleFactura detalleFactura) {
        Optional<DetalleFactura> existente = obtenerPorId(detalleFactura.getId());
        if (existente.isPresent()) {
            detalleFacturas.remove(existente.get());
            detalleFacturas.add(detalleFactura);
            return true;
        }
        return false;
    }
}
