// ResenaController.java
package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Resena;
import com.ejemplo.demo.service.ResenaService;
import io.javalin.Javalin;

public class ResenaController {
    private final ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    public void registrarRutas(Javalin app) {
        app.get("/resenas", ctx -> ctx.json(resenaService.listar()));
        app.get("/resenas/{id}", ctx -> ctx.json(resenaService.obtener(ctx.pathParam("id"))));
        app.post("/resenas", ctx -> ctx.json(resenaService.crear(ctx.bodyAsClass(Resena.class))));
        app.put("/resenas/{id}", ctx -> ctx.json(resenaService.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Resena.class))));
        app.delete("/resenas/{id}", ctx -> {
            resenaService.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
