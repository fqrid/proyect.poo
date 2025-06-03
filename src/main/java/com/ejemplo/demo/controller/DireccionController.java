package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Direccion;
import com.ejemplo.demo.service.DireccionService;
import io.javalin.Javalin;

public class DireccionController {
    private final DireccionService service;

    public DireccionController(DireccionService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.get("/direcciones", ctx -> ctx.json(service.listar()));
        app.get("/direcciones/{id}", ctx -> ctx.json(service.obtener(ctx.pathParam("id"))));
        app.post("/direcciones", ctx -> ctx.json(service.crear(ctx.bodyAsClass(Direccion.class))));
        app.put("/direcciones/{id}", ctx -> ctx.json(service.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Direccion.class))));
        app.delete("/direcciones/{id}", ctx -> {
            service.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
