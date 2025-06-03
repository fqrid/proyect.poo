package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Direccion;
import com.ejemplo.demo.repository.DireccionRepository;

import java.util.ArrayList;

public class DireccionService {
    private final DireccionRepository direccionRepository = new DireccionRepository();
    public void crearDireccion(Direccion direccion) {
        validar(direccion);
        direccionRepository.agregar(direccion);
    }

    public Direccion obtenerDireccion(int id) {
        Direccion d = direccionRepository.obtener(id);
        if (d == null) throw new NotFoundException("Dirección no encontrada");
        return d;
    }

    public ArrayList<Direccion> listarDirecciones() {
        return direccionRepository.obtenerTodas();
    }

    public Direccion actualizarDireccion(int id, Direccion direccion) {
        validar(direccion);
        Direccion d = direccionRepository.actualizar(id, direccion);
        if (d == null) throw new NotFoundException("Dirección no encontrada para actualizar");
        return d;
    }

    public Direccion eliminarDireccion(int id) {
        Direccion d = direccionRepository.eliminar(id);
        if (d == null) throw new NotFoundException("Dirección no encontrada para eliminar");
        return d;
    }

    private void validar(Direccion direccion) {
        if (direccion == null) throw new BadParameterException("Dirección no puede ser nula");
        if (direccion.getCalle() == null || direccion.getCalle().isEmpty())
            throw new BadParameterException("La calle no puede estar vacía");
        if (direccion.getCiudad() == null || direccion.getCiudad().isEmpty())
            throw new BadParameterException("La ciudad no puede estar vacía");
    }
}