package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.CarritoCompra;
import com.ejemplo.demo.service.CarritoCompraService;

public class CarritoCompraController {

    private final CarritoCompraService carritoService;

    public CarritoCompraController(CarritoCompraService carritoService) {
        this.carritoService = carritoService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/carritos", this::crear);
        app.get("/carritos/{id}", this::obtener);
        app.put("/carritos/{id}", this::actualizar);
        app.delete("/carritos/{id}", this::eliminar);
        app.get("/carritos", this::listar);
    }

    public void crear(Context ctx) {
        CarritoCompra carrito = ctx.bodyAsClass(CarritoCompra.class);
        carritoService.crear(carrito);
        ctx.status(201).json(carrito);
    }

    public void obtener(Context ctx) {
        ctx.json(carritoService.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        CarritoCompra actualizado = ctx.bodyAsClass(CarritoCompra.class);
        carritoService.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        carritoService.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Carrito eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(carritoService.listar());
    }
}
