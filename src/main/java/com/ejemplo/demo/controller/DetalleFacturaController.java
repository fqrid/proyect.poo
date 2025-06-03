// DetalleFacturaController.java
package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.DetalleFactura;
import com.ejemplo.demo.service.DetalleFacturaService;
import io.javalin.Javalin;

public class DetalleFacturaController {
    private final DetalleFacturaService detalleFacturaService;

    public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
        this.detalleFacturaService = detalleFacturaService;
    }

    public void registrarRutas(Javalin app) {
        app.get("/detalle-facturas", ctx -> ctx.json(detalleFacturaService.listar()));
        app.get("/detalle-facturas/{id}", ctx -> ctx.json(detalleFacturaService.obtener(ctx.pathParam("id"))));
        app.post("/detalle-facturas", ctx -> ctx.json(detalleFacturaService.crear(ctx.bodyAsClass(DetalleFactura.class))));
        app.put("/detalle-facturas/{id}", ctx -> ctx.json(detalleFacturaService.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(DetalleFactura.class))));
        app.delete("/detalle-facturas/{id}", ctx -> {
            detalleFacturaService.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
