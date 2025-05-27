package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public class DireccionController {

    private DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    // Agregar una nueva dirección
    public void agregarDireccion(Direccion direccion) {
        if (direccion != null) {
            direccionService.agregarDireccion(direccion);
            System.out.println(" Dirección agregada correctamente.");
        } else {
            System.out.println(" La dirección no puede ser nula.");
        }
    }

    // Mostrar todas las direcciones
    public void listarDirecciones() {
        List<Direccion> lista = direccionService.obtenerDirecciones();
        if (!lista.isEmpty()) {
            System.out.println(" Lista de direcciones:");
            for (Direccion d : lista) {
                System.out.println(d);
            }
        } else {
            System.out.println("ℹ No hay direcciones registradas.");
        }
    }

    // Buscar dirección por ID
    public void buscarDireccionPorId(int id) {
        Direccion direccion = direccionService.buscarPorId(id);
        if (direccion != null) {
            System.out.println(" Dirección encontrada:");
            System.out.println(direccion);
        } else {
            System.out.println(" No se encontró ninguna dirección con ID: " + id);
        }
    }

    // Eliminar dirección por ID
    public void eliminarDireccion(int id) {
        boolean eliminado = direccionService.eliminarDireccion(id);
        if (eliminado) {
            System.out.println(" Dirección eliminada correctamente.");
        } else {
            System.out.println(" No se pudo eliminar la dirección con ID: " + id);
        }
    }
}
