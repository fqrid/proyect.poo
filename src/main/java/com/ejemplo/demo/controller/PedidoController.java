package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.service.PedidoService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/pedidos", this::crear);
        app.get("/pedidos/{id}", this::obtener);
        app.put("/pedidos/{id}", this::actualizar);
        app.delete("/pedidos/{id}", this::eliminar);
        app.get("/pedidos", this::listar);
    }

    public void crear(Context ctx) {
        Pedido pedido = ctx.bodyAsClass(Pedido.class);
        service.crear(pedido);
        ctx.status(201).json(pedido);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Pedido actualizado = ctx.bodyAsClass(Pedido.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Pedido eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
