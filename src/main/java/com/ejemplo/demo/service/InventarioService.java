package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Inventario;
import com.ejemplo.demo.repository.InventarioRepository;

import java.util.List;

public class InventarioService {
    private final InventarioRepository inventarioRepository = new InventarioRepository();

    public void agregar(Inventario inventario) {
        validar(inventario);
        inventarioRepository.agregarInventario(inventario);
    }

    public Inventario eliminar(int id) {
        Inventario eliminado = inventarioRepository.eliminarInventario(id);
        if (eliminado == null) throw new NotFoundException("Inventario no encontrado");
        return eliminado;
    }

    public Inventario actualizar(int id, Inventario actualizado) {
        validar(actualizado);
        Inventario actualizadoOK = inventarioRepository.actualizarInventario(id, actualizado);
        if (actualizadoOK == null) throw new NotFoundException("Inventario no encontrado");
        return actualizadoOK;
    }

    public Inventario obtener(int id) {
        Inventario inventario = inventarioRepository.obtenerInventario(id);
        if (inventario == null) throw new NotFoundException("Inventario no encontrado");
        return inventario;
    }

    public List<Inventario> listar() {
        return inventarioRepository.obtenerInventarios();
    }

    private void validar(Inventario inventario) {
        if (inventario == null)
            throw new BadParameterException("El inventario no puede ser nulo");
        if (inventario.getProducto() == null || inventario.getProducto().isEmpty())
            throw new BadParameterException("El producto no puede estar vacío");
        if (inventario.getCantidad() < 0)
            throw new BadParameterException("La cantidad no puede ser negativa");
    }
}
