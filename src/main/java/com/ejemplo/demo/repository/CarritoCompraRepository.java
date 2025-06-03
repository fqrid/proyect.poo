package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.CarritoCompra;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CarritoCompraRepository {
    private final ArrayList<CarritoCompra> carritoCompras = new ArrayList<>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregar(CarritoCompra entidad) {
        entidad.setId(autoId.getAndIncrement());
        carritoCompras.add(entidad);
    }

    public CarritoCompra eliminar(int id) {
        for (int i = 0; i < carritoCompras.size(); i++) {
            if (carritoCompras.get(i).getId() == id) {
                return carritoCompras.remove(i);
            }
        }
        return null;
    }

    public CarritoCompra actualizar(int id, CarritoCompra entidad) {
        for (int i = 0; i < carritoCompras.size(); i++) {
            if (carritoCompras.get(i).getId() == id) {
                carritoCompras.set(i, entidad);
                return entidad;
            }
        }
        return null;
    }

    public CarritoCompra obtener(int id) {
        for (CarritoCompra entidad : carritoCompras) {
            if (entidad.getId() == id) {
                return entidad;
            }
        }
        return null;
    }

    public ArrayList<CarritoCompra> obtenerTodos() {
        return carritoCompras;
    }
}
