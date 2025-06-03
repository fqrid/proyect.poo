package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Descuento;
import com.ejemplo.demo.service.DescuentoService;

public class DescuentoController {

    private final DescuentoService service;

    public DescuentoController(DescuentoService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/descuentos", this::crear);
        app.get("/descuentos/{id}", this::obtener);
        app.put("/descuentos/{id}", this::actualizar);
        app.delete("/descuentos/{id}", this::eliminar);
        app.get("/descuentos", this::listar);
    }

    public void crear(Context ctx) {
        Descuento descuento = ctx.bodyAsClass(Descuento.class);
        service.crear(descuento);
        ctx.status(201).json(descuento);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Descuento actualizado = ctx.bodyAsClass(Descuento.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Descuento eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
