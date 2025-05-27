package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CarritoController {

    private CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    // Agregar un producto al carrito
    public void agregarAlCarrito(Carrito item) {
        if (item != null) {
            carritoService.agregarProducto(item);
            System.out.println(" Producto agregado al carrito correctamente.");
        } else {
            System.out.println(" El producto no puede ser nulo.");
        }
    }

    // Mostrar el contenido del carrito
    public void mostrarCarrito() {
        List<Carrito> items = carritoService.obtenerContenido();
        if (!items.isEmpty()) {
            System.out.println(" Productos en el carrito:");
            for (Carrito c : items) {
                System.out.println(c);
            }
        } else {
            System.out.println("ℹ El carrito está vacío.");
        }
    }

    // Eliminar un producto del carrito
    public void eliminarDelCarrito(int idProducto) {
        boolean eliminado = carritoService.eliminarProducto(idProducto);
        if (eliminado) {
            System.out.println(" Producto eliminado del carrito.");
        } else {
            System.out.println(" No se encontró el producto en el carrito.");
        }
    }

    // Vaciar el carrito completamente
    public void vaciarCarrito(p) {
        carritoService.vaciarCarrito();
        System.out.println(" Carrito vaciado correctamente.");
    }
}
