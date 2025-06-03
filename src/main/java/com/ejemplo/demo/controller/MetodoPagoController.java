package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.MetodoPago;
import com.ejemplo.demo.service.MetodoPagoService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class MetodoPagoController {

    private final MetodoPagoService service;

    public MetodoPagoController(MetodoPagoService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/metodos-pago", this::crear);
        app.get("/metodos-pago/{id}", this::obtener);
        app.put("/metodos-pago/{id}", this::actualizar);
        app.delete("/metodos-pago/{id}", this::eliminar);
        app.get("/metodos-pago", this::listar);
    }

    public void crear(Context ctx) {
        MetodoPago m = ctx.bodyAsClass(MetodoPago.class);
        service.crear(m);
        ctx.status(201).json(m);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        MetodoPago actualizado = ctx.bodyAsClass(MetodoPago.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Método de pago eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}

