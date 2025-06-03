package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Descuento;
import com.ejemplo.demo.service.DescuentoService;
import io.javalin.Javalin;

public class DescuentoController {
    private final DescuentoService service;

    public DescuentoController(DescuentoService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.get("/descuentos", ctx -> ctx.json(service.listar()));
        app.get("/descuentos/{id}", ctx -> ctx.json(service.obtener(ctx.pathParam("id"))));
        app.post("/descuentos", ctx -> ctx.json(service.crear(ctx.bodyAsClass(Descuento.class))));
        app.put("/descuentos/{id}", ctx -> ctx.json(service.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Descuento.class))));
        app.delete("/descuentos/{id}", ctx -> {
            service.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
