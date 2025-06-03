package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Resena;
import com.ejemplo.demo.service.ResenaService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class ResenaController {

    private final ResenaService service;

    public ResenaController(ResenaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/resenas", this::crear);
        app.get("/resenas/{id}", this::obtener);
        app.put("/resenas/{id}", this::actualizar);
        app.delete("/resenas/{id}", this::eliminar);
        app.get("/resenas", this::listar);
    }

    public void crear(Context ctx) {
        Resena resena = ctx.bodyAsClass(Resena.class);
        service.crear(resena);
        ctx.status(201).json(resena);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Resena actualizado = ctx.bodyAsClass(Resena.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Reseña eliminada");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
