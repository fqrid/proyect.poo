package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Comentario;
import com.ejemplo.demo.service.ComentarioService;

public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/comentarios", this::crear);
        app.get("/comentarios/{id}", this::obtener);
        app.put("/comentarios/{id}", this::actualizar);
        app.delete("/comentarios/{id}", this::eliminar);
        app.get("/comentarios", this::listar);
    }

    public void crear(Context ctx) {
        Comentario comentario = ctx.bodyAsClass(Comentario.class);
        service.crear(comentario);
        ctx.status(201).json(comentario);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Comentario actualizado = ctx.bodyAsClass(Comentario.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Comentario eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
