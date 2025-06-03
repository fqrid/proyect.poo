package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Rol;
import com.ejemplo.demo.service.RolService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class RolController {

    private final RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/roles", this::crear);
        app.get("/roles/{id}", this::obtener);
        app.put("/roles/{id}", this::actualizar);
        app.delete("/roles/{id}", this::eliminar);
        app.get("/roles", this::listar);
    }

    public void crear(Context ctx) {
        Rol r = ctx.bodyAsClass(Rol.class);
        service.crear(r);
        ctx.status(201).json(r);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Rol r = ctx.bodyAsClass(Rol.class);
        service.actualizar(ctx.pathParam("id"), r);
        ctx.json(r);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.result("Rol eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
