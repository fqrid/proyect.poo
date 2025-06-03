package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.MetodoPago;
import com.ejemplo.demo.service.MetodoPagoService;

public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    public MetodoPagoController(MetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/metodos-pago", this::guardar);
        app.get("/metodos-pago/{id}", this::obtener);
        app.delete("/metodos-pago/{id}", this::eliminar);
        app.put("/metodos-pago/{id}", this::actualizar);
        app.get("/metodos-pago", this::listar);
    }

    public void guardar(Context ctx) {
        MetodoPago mp = ctx.bodyAsClass(MetodoPago.class);
        metodoPagoService.guardarMetodoPago(mp);
        ctx.status(201).json(mp);
    }

    public void obtener(Context ctx) {
        ctx.json(metodoPagoService.obtenerMetodoPago(ctx.pathParam("id")));
    }

    public void eliminar(Context ctx) {
        metodoPagoService.eliminarMetodoPago(ctx.pathParam("id"));
        ctx.status(200).result("Método de pago eliminado");
    }

    public void actualizar(Context ctx) {
        MetodoPago mp = ctx.bodyAsClass(MetodoPago.class);
        metodoPagoService.actualizarMetodoPago(ctx.pathParam("id"), mp);
        ctx.status(200).json(mp);
    }

    public void listar(Context ctx) {
        ctx.json(metodoPagoService.obtenerMetodosPago());
    }
}
