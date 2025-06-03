// DireccionController.java
package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Direccion;
import com.ejemplo.demo.service.DireccionService;
import io.javalin.Javalin;

public class DireccionController {
    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    public void registrarRutas(Javalin app) {
        app.get("/direcciones", ctx -> ctx.json(direccionService.listar()));
        app.get("/direcciones/{id}", ctx -> ctx.json(direccionService.obtener(ctx.pathParam("id"))));
        app.post("/direcciones", ctx -> ctx.json(direccionService.crear(ctx.bodyAsClass(Direccion.class))));
        app.put("/direcciones/{id}", ctx -> ctx.json(direccionService.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Direccion.class))));
        app.delete("/direcciones/{id}", ctx -> {
            direccionService.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
