package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public class DetalleFacturaController {

    private DetalleFacturaService detalleService;

    public DetalleFacturaController(DetalleFacturaService detalleService) {
        this.detalleService = detalleService;
    }

    // Agregar un nuevo detalle a una factura
    public void agregarDetalle(DetalleFactura detalle) {
        if (detalle != null) {
            detalleService.agregarDetalle(detalle);
            System.out.println(" Detalle agregado correctamente.");
        } else {
            System.out.println(" El detalle no puede ser nulo.");
        }
    }

    // Listar todos los detalles registrados
    public void listarDetalles() {
        List<DetalleFactura> lista = detalleService.obtenerDetalles();
        if (!lista.isEmpty()) {
            System.out.println(" Lista de detalles de facturas:");
            for (DetalleFactura df : lista) {
                System.out.println(df);
            }
        } else {
            System.out.println("ℹ No hay detalles registrados.");
        }
    }

    // Buscar un detalle por ID
    public void buscarDetallePorId(int id) {
        DetalleFactura detalle = detalleService.buscarPorId(id);
        if (detalle != null) {
            System.out.println(" Detalle encontrado:");
            System.out.println(detalle);
        } else {
            System.out.println(" No se encontró ningún detalle con ID: " + id);
        }
    }

    // Eliminar un detalle
    public void eliminarDetalle(int id) {
        boolean eliminado = detalleService.eliminarDetalle(id);
        if (eliminado) {
            System.out.println(" Detalle eliminado correctamente.");
        } else {
            System.out.println(" No se pudo eliminar el detalle con ID: " + id);
        }
    }
}
