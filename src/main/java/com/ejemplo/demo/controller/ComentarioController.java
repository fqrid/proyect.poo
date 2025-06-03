// ComentarioController.java
package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Comentario;
import com.ejemplo.demo.service.ComentarioService;
import io.javalin.Javalin;

public class ComentarioController {
    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    public void registrarRutas(Javalin app) {
        app.get("/comentarios", ctx -> ctx.json(comentarioService.listar()));
        app.get("/comentarios/{id}", ctx -> ctx.json(comentarioService.obtener(ctx.pathParam("id"))));
        app.post("/comentarios", ctx -> ctx.json(comentarioService.crear(ctx.bodyAsClass(Comentario.class))));
        app.put("/comentarios/{id}", ctx -> ctx.json(comentarioService.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Comentario.class))));
        app.delete("/comentarios/{id}", ctx -> {
            comentarioService.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
