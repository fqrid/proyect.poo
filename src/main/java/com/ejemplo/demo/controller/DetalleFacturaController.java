package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.DetalleFactura;
import com.ejemplo.demo.service.DetalleFacturaService;

public class DetalleFacturaController {

    private final DetalleFacturaService service;

    public DetalleFacturaController(DetalleFacturaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/detalles-factura", this::crear);
        app.get("/detalles-factura/{id}", this::obtener);
        app.put("/detalles-factura/{id}", this::actualizar);
        app.delete("/detalles-factura/{id}", this::eliminar);
        app.get("/detalles-factura", this::listar);
    }

    public void crear(Context ctx) {
        DetalleFactura detalle = ctx.bodyAsClass(DetalleFactura.class);
        service.crear(detalle);
        ctx.status(201).json(detalle);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        DetalleFactura actualizado = ctx.bodyAsClass(DetalleFactura.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Detalle de factura eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
