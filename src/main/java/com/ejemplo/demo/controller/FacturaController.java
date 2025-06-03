package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Factura;
import com.ejemplo.demo.service.FacturaService;

public class FacturaController {

    private final FacturaService service;

    public FacturaController(FacturaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/facturas", this::crear);
        app.get("/facturas/{id}", this::obtener);
        app.put("/facturas/{id}", this::actualizar);
        app.delete("/facturas/{id}", this::eliminar);
        app.get("/facturas", this::listar);
    }

    public void crear(Context ctx) {
        Factura factura = ctx.bodyAsClass(Factura.class);
        service.crear(factura);
        ctx.status(201).json(factura);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Factura actualizada = ctx.bodyAsClass(Factura.class);
        service.actualizar(ctx.pathParam("id"), actualizada);
        ctx.status(200).json(actualizada);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Factura eliminada");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
