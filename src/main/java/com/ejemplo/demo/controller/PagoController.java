package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Pago;
import com.ejemplo.demo.service.PagoService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/pagos", this::crear);
        app.get("/pagos/{id}", this::obtener);
        app.put("/pagos/{id}", this::actualizar);
        app.delete("/pagos/{id}", this::eliminar);
        app.get("/pagos", this::listar);
    }

    public void crear(Context ctx) {
        Pago pago = ctx.bodyAsClass(Pago.class);
        service.crear(pago);
        ctx.status(201).json(pago);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Pago actualizado = ctx.bodyAsClass(Pago.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Pago eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
