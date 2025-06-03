package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.CarritoCompra;
import com.ejemplo.demo.service.CarritoCompraService;
import io.javalin.Javalin;

public class CarritoCompraController {
    private final CarritoCompraService service;

    public CarritoCompraController(CarritoCompraService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.get("/carritos", ctx -> ctx.json(service.listar()));
        app.get("/carritos/{id}", ctx -> ctx.json(service.obtener(ctx.pathParam("id"))));
        app.post("/carritos", ctx -> ctx.json(service.crear(ctx.bodyAsClass(CarritoCompra.class))));
        app.put("/carritos/{id}", ctx -> ctx.json(service.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(CarritoCompra.class))));
        app.delete("/carritos/{id}", ctx -> {
            service.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
