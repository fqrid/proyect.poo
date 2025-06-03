package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Inventario;
import com.ejemplo.demo.repository.InventarioRepository;

import java.util.List;

public class InventarioService {

    private final InventarioRepository repository;

    public InventarioService(InventarioRepository repository) {
        this.repository = repository;
    }

    private void validar(Inventario i) {
        if (i == null) throw new BadParameterException("Inventario no puede ser null");
        if (i.getProducto() == null) throw new BadParameterException("Debe tener producto");
        if (i.getCantidad() < 0) throw new BadParameterException("Cantidad no puede ser negativa");
    }

    public void guardar(Inventario inventario) {
        validar(inventario);
        repository.guardar(inventario);
    }

    public void eliminar(String id) {
        Inventario eliminado = repository.eliminar(Integer.parseInt(id));
        if (eliminado == null) throw new NotFoundException("Inventario no encontrado");
    }

    public void actualizar(String id, Inventario nuevo) {
        validar(nuevo);
        Inventario actualizado = repository.actualizar(Integer.parseInt(id), nuevo);
        if (actualizado == null) throw new NotFoundException("Inventario no encontrado");
    }

    public Inventario obtener(String id) {
        Inventario inventario = repository.obtener(Integer.parseInt(id));
        if (inventario == null) throw new NotFoundException("Inventario no encontrado");
        return inventario;
    }

    public List<Inventario> obtenerTodos() {
        return repository.obtenerTodos();
    }
}