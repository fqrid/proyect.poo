package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Direccion;
import com.ejemplo.demo.service.DireccionService;

public class DireccionController {

    private final DireccionService service;

    public DireccionController(DireccionService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/direcciones", this::crear);
        app.get("/direcciones/{id}", this::obtener);
        app.put("/direcciones/{id}", this::actualizar);
        app.delete("/direcciones/{id}", this::eliminar);
        app.get("/direcciones", this::listar);
    }

    public void crear(Context ctx) {
        Direccion direccion = ctx.bodyAsClass(Direccion.class);
        service.crear(direccion);
        ctx.status(201).json(direccion);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Direccion actualizada = ctx.bodyAsClass(Direccion.class);
        service.actualizar(ctx.pathParam("id"), actualizada);
        ctx.status(200).json(actualizada);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Dirección eliminada");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
