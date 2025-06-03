package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.DetalleFactura;
import com.ejemplo.demo.service.DetalleFacturaService;
import io.javalin.Javalin;

public class DetalleFacturaController {
    private final DetalleFacturaService service;

    public DetalleFacturaController(DetalleFacturaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.get("/detalles-factura", ctx -> ctx.json(service.listar()));
        app.get("/detalles-factura/{id}", ctx -> ctx.json(service.obtener(ctx.pathParam("id"))));
        app.post("/detalles-factura", ctx -> ctx.json(service.crear(ctx.bodyAsClass(DetalleFactura.class))));
        app.put("/detalles-factura/{id}", ctx -> ctx.json(service.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(DetalleFactura.class))));
        app.delete("/detalles-factura/{id}", ctx -> {
            service.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
