package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.CarritoCompra;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CarritoCompraRepository {

    private final List<CarritoCompra> carritoCompras = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void save(CarritoCompra carrito) {
        carrito.setId(String.valueOf(autoId.getAndIncrement()));
        carritoCompras.add(carrito);
    }

    public CarritoCompra findById(String id) {
        for (CarritoCompra c : carritoCompras) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void update(String id, CarritoCompra actualizado) {
        for (int i = 0; i < carritoCompras.size(); i++) {
            if (carritoCompras.get(i).getId().equals(id)) {
                actualizado.setId(id);
                carritoCompras.set(i, actualizado);
                return;
            }
        }
    }

    public void deleteById(String id) {
        carritoCompras.removeIf(c -> c.getId().equals(id));
    }

    public List<CarritoCompra> findAll() {
        return new ArrayList<>(carritoCompras);
    }
}