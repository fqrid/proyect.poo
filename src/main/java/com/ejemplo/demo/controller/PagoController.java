package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Pago;
import com.ejemplo.demo.service.PagoService;

public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/pagos", this::guardarPago);
        app.get("/pagos/{id}", this::obtenerPago);
        app.delete("/pagos/{id}", this::eliminarPago);
        app.put("/pagos/{id}", this::actualizarPago);
        app.get("/pagos", this::listarPagos);
    }

    public void guardarPago(Context ctx) {
        Pago pago = ctx.bodyAsClass(Pago.class);
        pagoService.guardarPago(pago);
        ctx.status(201).json(pago);
    }

    public void obtenerPago(Context ctx) {
        ctx.json(pagoService.obtenerPago(ctx.pathParam("id")));
    }

    public void eliminarPago(Context ctx) {
        pagoService.eliminarPago(ctx.pathParam("id"));
        ctx.status(200).result("Pago eliminado");
    }

    public void actualizarPago(Context ctx) {
        Pago pago = ctx.bodyAsClass(Pago.class);
        pagoService.actualizarPago(ctx.pathParam("id"), pago);
        ctx.status(200).json(pago);
    }

    public void listarPagos(Context ctx) {
        ctx.json(pagoService.obtenerPagos());
    }
}
