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
        app.post("/item-carrito", this::crear);
        app.get("/item-carrito/{id}", this::obtener);
        app.put("/item-carrito/{id}", this::actualizar);
        app.delete("/item-carrito/{id}", this::eliminar);
        app.get("/item-carrito", this::listar);
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
        ItemCarrito actualizado = ctx.bodyAsClass(ItemCarrito.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("ItemCarrito eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
