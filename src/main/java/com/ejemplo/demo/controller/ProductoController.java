package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.service.ProductoService;

public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/productos", this::guardarProducto);
        app.get("/productos/{id}", this::obtenerProducto);
        app.delete("/productos/{id}", this::eliminarProducto);
        app.put("/productos/{id}", this::actualizarProducto);
        app.get("/productos", this::listarProductos);
    }

    public void guardarProducto(Context ctx) {
        ctx.contentType("application/json");
        Producto producto = ctx.bodyAsClass(Producto.class);
        productoService.guardarProducto(producto);
        ctx.status(201).json(producto);
    }

    public void obtenerProducto(Context ctx) {
        String id = ctx.pathParam("id");
        ctx.json(productoService.obtenerProducto(id));
    }

    public void eliminarProducto(Context ctx) {
        String id = ctx.pathParam("id");
        productoService.eliminarProducto(id);
        ctx.status(200).result("Producto eliminado con ID: " + id);
    }

    public void actualizarProducto(Context ctx) {
        String id = ctx.pathParam("id");
        Producto producto = ctx.bodyAsClass(Producto.class);
        productoService.actualizarProducto(id, producto);
        ctx.status(200).json(producto);
    }

    public void listarProductos(Context ctx) {
        ctx.json(productoService.obtenerProductos());
    }
}
