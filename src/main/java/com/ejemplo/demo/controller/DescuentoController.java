// DescuentoController.java
package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Descuento;
import com.ejemplo.demo.service.DescuentoService;
import io.javalin.Javalin;

public class DescuentoController {
    private final DescuentoService descuentoService;

    public DescuentoController(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    public void registrarRutas(Javalin app) {
        app.get("/descuentos", ctx -> ctx.json(descuentoService.listar()));
        app.get("/descuentos/{id}", ctx -> ctx.json(descuentoService.obtener(Long.parseLong(ctx.pathParam("id")))));
        app.post("/descuentos", ctx -> ctx.json(descuentoService.crear(ctx.bodyAsClass(Descuento.class))));
        app.put("/descuentos/{id}", ctx -> ctx.json(descuentoService.actualizar(Long.parseLong(ctx.pathParam("id")), ctx.bodyAsClass(Descuento.class))));
        app.delete("/descuentos/{id}", ctx -> {
            descuentoService.eliminar(Long.parseLong(ctx.pathParam("id")));
            ctx.status(204);
        });
    }
}
