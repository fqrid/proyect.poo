package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Comentario;
import com.ejemplo.demo.service.ComentarioService;
import io.javalin.Javalin;

public class ComentarioController {
    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.get("/comentarios", ctx -> ctx.json(service.listar()));
        app.get("/comentarios/{id}", ctx -> ctx.json(service.obtener(ctx.pathParam("id"))));
        app.post("/comentarios", ctx -> ctx.json(service.crear(ctx.bodyAsClass(Comentario.class))));
        app.put("/comentarios/{id}", ctx -> ctx.json(service.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Comentario.class))));
        app.delete("/comentarios/{id}", ctx -> {
            service.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
