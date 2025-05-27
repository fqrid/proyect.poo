package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.ejemplo.demo.model.Factura;

public class DescuentoController {

    private DescuentoService descuentoService;

    public DescuentoController(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    // Agregar un nuevo descuento
    public void agregarDescuento(Descuento descuento) {
        if (descuento != null) {
            descuentoService.agregarDescuento(descuento);
            System.out.println(" Descuento agregado correctamente.");
        } else {
            System.out.println(" El descuento no puede ser nulo.");
        }
    }

    // Listar todos los descuentos
    public void listarDescuentos() {
        List<Descuento> lista = descuentoService.obtenerDescuentos();
        if (!lista.isEmpty()) {
            System.out.println(" Descuentos registrados:");
            for (Descuento d : lista) {
                System.out.println(d);
            }
        } else {
            System.out.println("ℹ No hay descuentos registrados.");
        }
    }

    // Buscar un descuento por ID
    public void buscarDescuentoPorId(int id) {
        Descuento descuento = descuentoService.buscarPorId(id);
        if (descuento != null) {
            System.out.println(" Descuento encontrado:");
            System.out.println(descuento);
        } else {
            System.out.println(" No se encontró ningún descuento con ID: " + id);
        }
    }

    // Eliminar descuento por ID
    public void eliminarDescuento(int id) {
        boolean eliminado = descuentoService.eliminarDescuento(id);
        if (eliminado) {
            System.out.println(" Descuento eliminado correctamente.");
        } else {
            System.out.println(" No se pudo eliminar el descuento con ID: " + id);
        }
    }
}
