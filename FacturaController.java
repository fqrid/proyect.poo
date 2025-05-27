package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public class FacturaController {

    private FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    // Crear una nueva factura
    public void crearFactura(Factura factura) {
        if (factura != null) {
            facturaService.crearFactura(factura);
            System.out.println("Factura creada correctamente.");
        } else {
            System.out.println(" La factura no puede ser nula.");
        }
    }

    // Obtener y mostrar todas las facturas
    public void listarFacturas() {
        List<Factura> lista = facturaService.obtenerFacturas();
        if (!lista.isEmpty()) {
            System.out.println(" Lista de facturas:");
            for (Factura f : lista) {
                System.out.println(f);
            }
        } else {
            System.out.println("ℹ No hay facturas registradas.");
        }
    }

    // Buscar una factura por ID
    public void buscarFactura(int id) {
        Factura factura = facturaService.buscarFacturaPorId(id);
        if (factura != null) {
            System.out.println(" Factura encontrada:");
            System.out.println(factura);
        } else {
            System.out.println(" No se encontró ninguna factura con ID: " + id);
        }
    }

    // Eliminar una factura por ID
    public void eliminarFactura(int id) {
        boolean eliminado = facturaService.eliminarFactura(id);
        if (eliminado) {
            System.out.println(" Factura eliminada correctamente.");
        } else {
            System.out.println(" No se pudo eliminar la factura con ID: " + id);
        }
    }
}
