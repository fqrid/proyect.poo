package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.ItemCarrito;
import com.ejemplo.demo.service.ItemCarritoService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class ItemCarritoController {

    private final ItemCarritoService service;

    public ItemCarritoController(ItemCarritoService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/items-carrito", this::crear);
        app.get("/items-carrito/{id}", this::obtener);
        app.put("/items-carrito/{id}", this::actualizar);
        app.delete("/items-carrito/{id}", this::eliminar);
        app.get("/items-carrito", this::listar);
    }

    public void crear(Context ctx) {
        ItemCarrito item = ctx.bodyAsClass(ItemCarrito.class);
        service.crear(item);
        ctx.status(201).json(item);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        ItemCarrito item = ctx.bodyAsClass(ItemCarrito.class);
        service.actualizar(ctx.pathParam("id"), item);
        ctx.status(200).json(item);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Item de carrito eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
