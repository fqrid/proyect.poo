package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Factura;
import com.ejemplo.demo.repository.FacturaRepository;

import java.util.List;

public class FacturaService {
    private final FacturaRepository repository;

    public FacturaService(FacturaRepository repository) {
        this.repository = repository;
    }

    private void validar(Factura f) {
        if (f == null) throw new BadParameterException("Factura inválida");
        if (f.getCliente() == null) throw new BadParameterException("Factura debe tener cliente");
        if (f.getTotal() <= 0) throw new BadParameterException("Total debe ser mayor que cero");
    }

    public void guardar(Factura f) {
        validar(f);
        repository.guardar(f);
    }

    public void eliminar(String id) {
        Factura r = repository.eliminar(Integer.parseInt(id));
        if (r == null) throw new NotFoundException("No existe Factura");
    }

    public void actualizar(String id, Factura nuevo) {
        validar(nuevo);
        Factura actualizado = repository.actualizar(Integer.parseInt(id), nuevo);
        if (actualizado == null) throw new NotFoundException("No existe Factura");
    }

    public Factura obtener(String id) {
        Factura r = repository.obtener(Integer.parseInt(id));
        if (r == null) throw new NotFoundException("No existe Factura");
        return r;
    }

    public List<Factura> obtenerTodos() {
        return repository.obtenerTodos();
    }
}