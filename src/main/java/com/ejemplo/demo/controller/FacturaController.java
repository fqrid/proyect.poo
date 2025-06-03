package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Factura;
import com.ejemplo.demo.service.FacturaService;
import io.javalin.Javalin;

public class FacturaController {
    private final FacturaService service;

    public FacturaController(FacturaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.get("/facturas", ctx -> ctx.json(service.listar()));
        app.get("/facturas/{id}", ctx -> ctx.json(service.obtener(ctx.pathParam("id"))));
        app.post("/facturas", ctx -> ctx.json(service.crear(ctx.bodyAsClass(Factura.class))));
        app.put("/facturas/{id}", ctx -> ctx.json(service.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Factura.class))));
        app.delete("/facturas/{id}", ctx -> {
            service.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
