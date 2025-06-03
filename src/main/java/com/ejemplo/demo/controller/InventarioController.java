package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Inventario;
import com.ejemplo.demo.service.InventarioService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class InventarioController {

    private final InventarioService service;

    public InventarioController(InventarioService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/inventarios", this::crear);
        app.get("/inventarios/{id}", this::obtener);
        app.put("/inventarios/{id}", this::actualizar);
        app.delete("/inventarios/{id}", this::eliminar);
        app.get("/inventarios", this::listar);
    }

    public void crear(Context ctx) {
        Inventario i = ctx.bodyAsClass(Inventario.class);
        service.crear(i);
        ctx.status(201).json(i);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Inventario i = ctx.bodyAsClass(Inventario.class);
        service.actualizar(ctx.pathParam("id"), i);
        ctx.json(i);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.result("Inventario eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
