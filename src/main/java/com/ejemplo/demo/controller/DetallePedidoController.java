package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.DetallePedido;
import com.ejemplo.demo.service.DetallePedidoService;

public class DetallePedidoController {

    private final DetallePedidoService service;

    public DetallePedidoController(DetallePedidoService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/detalles-pedido", this::crear);
        app.get("/detalles-pedido/{id}", this::obtener);
        app.put("/detalles-pedido/{id}", this::actualizar);
        app.delete("/detalles-pedido/{id}", this::eliminar);
        app.get("/detalles-pedido", this::listar);
    }

    public void crear(Context ctx) {
        DetallePedido detalle = ctx.bodyAsClass(DetallePedido.class);
        service.crear(detalle);
        ctx.status(201).json(detalle);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        DetallePedido actualizado = ctx.bodyAsClass(DetallePedido.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Detalle de pedido eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
