package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.service.ProductoService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/productos", this::crear);
        app.get("/productos/{id}", this::obtener);
        app.put("/productos/{id}", this::actualizar);
        app.delete("/productos/{id}", this::eliminar);
        app.get("/productos", this::listar);
    }

    public void crear(Context ctx) {
        Producto producto = ctx.bodyAsClass(Producto.class);
        service.crear(producto);
        ctx.status(201).json(producto);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Producto actualizado = ctx.bodyAsClass(Producto.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Producto eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
