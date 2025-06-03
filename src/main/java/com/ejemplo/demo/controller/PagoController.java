// PagoController.java
package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Pago;
import com.ejemplo.demo.service.PagoService;
import io.javalin.Javalin;

public class PagoController {
    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    public void registrarRutas(Javalin app) {
        app.get("/pagos", ctx -> ctx.json(pagoService.listar()));
        app.get("/pagos/{id}", ctx -> ctx.json(pagoService.obtener(ctx.pathParam("id"))));
        app.post("/pagos", ctx -> ctx.json(pagoService.crear(ctx.bodyAsClass(Pago.class))));
        app.put("/pagos/{id}", ctx -> ctx.json(pagoService.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Pago.class))));
        app.delete("/pagos/{id}", ctx -> {
            pagoService.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
