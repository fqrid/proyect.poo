package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FacturaRepository {

    private final List<Factura> facturas = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarFactura(Factura factura) {
        factura.setId((long) autoId.getAndIncrement());
        facturas.add(factura);
    }

    public Factura eliminarFactura(int id) {
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getId() == id) {
                return facturas.remove(i);
            }
        }
        return null;
    }

    public Factura actualizarFactura(int id, Factura facturaActualizada) {
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getId() == id) {
                facturaActualizada.setId((long) id);
                facturas.set(i, facturaActualizada);
                return facturaActualizada;
            }
        }
        return null;
    }

    public Factura obtenerFactura(int id) {
        for (Factura factura : facturas) {
            if (factura.getId() == id) {
                return factura;
            }
        }
        return null;
    }

    public List<Factura> obtenerFacturas() {
        return facturas;
    }
}