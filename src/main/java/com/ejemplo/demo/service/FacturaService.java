package com.ejemplo.demo.service;

import com.ejemplo.demo.exception.BadParameterException;
import com.ejemplo.demo.exception.NotFoundException;
import com.ejemplo.demo.model.Factura;
import com.ejemplo.demo.repository.FacturaRepository;

import java.util.List;

public class FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    private void validarFactura(Factura factura) {
        if (factura == null) {
            throw new BadParameterException("La factura no puede ser nula");
        }
        if (factura.getFecha() == null || factura.getFecha().isEmpty()) {
            throw new BadParameterException("La fecha de la factura no puede estar vacía");
        }
        if (factura.getTotal() == null || factura.getTotal().isEmpty()) {
            throw new BadParameterException("El total de la factura no puede estar vacío");
        }

        try {
            double total = Double.parseDouble(factura.getTotal());
            if (total <= 0) {
                throw new BadParameterException("El total debe ser mayor a cero");
            }
        } catch (NumberFormatException e) {
            throw new BadParameterException("El total debe ser un número válido");
        }
    }

    public void guardarFactura(Factura factura) {
        validarFactura(factura);
        facturaRepository.agregarFactura(factura);
    }

    public void eliminarFactura(String id) {
        if (id == null) {
            throw new NotFoundException("No se proporcionó ID");
        }
        Factura eliminado = facturaRepository.eliminarFactura(Integer.parseInt(id));
        if (eliminado == null) {
            throw new NotFoundException("Factura no encontrada");
        }
    }

    public void actualizarFactura(String id, Factura factura) {
        if (id == null) {
            throw new NotFoundException("No se proporcionó ID");
        }
        validarFactura(factura);
        Factura actualizada = facturaRepository.actualizarFactura(Integer.parseInt(id), factura);
        if (actualizada == null) {
            throw new NotFoundException("Factura no encontrada");
        }
    }

    public Factura obtenerFactura(String id) {
        if (id == null) {
            throw new NotFoundException("No se proporcionó ID");
        }
        Factura factura = facturaRepository.obtenerFactura(Integer.parseInt(id));
        if (factura == null) {
            throw new NotFoundException("Factura no encontrada");
        }
        return factura;
    }

    public List<Factura> obtenerFacturas() {
        return facturaRepository.obtenerFacturas();
    }
}