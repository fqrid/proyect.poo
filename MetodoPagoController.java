package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class MetodoPagoController {

    private MetodoPagoService metodoPagoService;

    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    // Agregar un nuevo método de pago
    public void agregarMetodoPago(MetodoPago metodo) {
        if (metodo != null) {
            metodoPagoService.agregarMetodo(metodo);
            System.out.println(" Método de pago agregado correctamente.");
        } else {
            System.out.println(" El método de pago no puede ser nulo.");
        }
    }

    // Listar todos los métodos de pago
    public void listarMetodosPago() {
        List<MetodoPago> lista = metodoPagoService.obtenerMetodos();
        if (!lista.isEmpty()) {
            System.out.println(" Métodos de pago registrados:");
            for (MetodoPago m : lista) {
                System.out.println(m);
            }
        } else {
            System.out.println("ℹ No hay métodos de pago registrados.");
        }
    }

    // Buscar un método de pago por ID
    public void buscarMetodoPorId(int id) {
        MetodoPago metodo = metodoPagoService.buscarPorId(id);
        if (metodo != null) {
            System.out.println(" Método de pago encontrado:");
            System.out.println(metodo);
        } else {
            System.out.println(" No se encontró método de pago con ID: " + id);
        }
    }

    // Eliminar método de pago por ID
    public void eliminarMetodoPago(int id) {
        boolean eliminado = metodoPagoService.eliminarMetodo(id);
        if (eliminado) {
            System.out.println(" Método de pago eliminado correctamente.");
        } else {
            System.out.println(" No se pudo eliminar el método de pago con ID: " + id);
        }
    }
}
