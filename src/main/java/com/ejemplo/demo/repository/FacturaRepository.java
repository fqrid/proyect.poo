package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FacturaRepository {
    private final List<Factura> facturas = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void guardar(Factura f) {
        if (f.getId() == null) {
            f.setId(autoId.getAndIncrement());
        }
        facturas.add(f);
    }

    public Factura eliminar(int id) {
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getId().equals(id)) {
                return facturas.remove(i);
            }
        }
        return null;
    }

    public Factura actualizar(int id, Factura nueva) {
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getId().equals(id)) {
                nueva.setId(id);
                facturas.set(i, nueva);
                return nueva;
            }
        }
        return null;
    }

    public Factura obtener(int id) {
        for (Factura f : facturas) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    public List<Factura> obtenerTodos() {
        return new ArrayList<>(facturas);
    }
}