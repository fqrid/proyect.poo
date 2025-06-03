package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.CarritoCompra;
import com.ejemplo.demo.service.CarritoCompraService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class CarritoCompraController {

    private final CarritoCompraService service;

    public CarritoCompraController(CarritoCompraService service) {
        this.service = service;
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
        service.crear(carrito);
        ctx.status(201).json(carrito);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        CarritoCompra actualizado = ctx.bodyAsClass(CarritoCompra.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Carrito eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
