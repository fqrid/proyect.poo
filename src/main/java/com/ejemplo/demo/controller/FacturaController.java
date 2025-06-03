// FacturaController.java
package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Factura;
import com.ejemplo.demo.service.FacturaService;
import io.javalin.Javalin;

public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    public void registrarRutas(Javalin app) {
        app.get("/facturas", ctx -> ctx.json(facturaService.listar()));
        app.get("/facturas/{id}", ctx -> ctx.json(facturaService.obtener(ctx.pathParam("id"))));
        app.post("/facturas", ctx -> ctx.json(facturaService.crear(ctx.bodyAsClass(Factura.class))));
        app.put("/facturas/{id}", ctx -> ctx.json(facturaService.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Factura.class))));
        app.delete("/facturas/{id}", ctx -> {
            facturaService.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
