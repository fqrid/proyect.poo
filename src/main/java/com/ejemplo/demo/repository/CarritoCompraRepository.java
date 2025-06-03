package com.ejemplo.demo.repository;

import com.ejemplo.demo.model.CarritoCompra;
import java.util.*;

public class CarritoCompraRepository {
    private final Map<String, CarritoCompra> datos = new HashMap<>();

    public CarritoCompra save(CarritoCompra carrito) {
        datos.put(carrito.getId(), carrito);
        return carrito;
    }

    public Optional<CarritoCompra> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    public List<CarritoCompra> findAll() {
        return new ArrayList<>(datos.values());
    }

    public void deleteById(String id) {
        datos.remove(id);
    }
}
