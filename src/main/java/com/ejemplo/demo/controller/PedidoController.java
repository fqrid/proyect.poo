package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.service.PedidoService;

public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/pedidos", this::guardarPedido);
        app.get("/pedidos/{id}", this::obtenerPedido);
        app.delete("/pedidos/{id}", this::eliminarPedido);
        app.put("/pedidos/{id}", this::actualizarPedido);
        app.get("/pedidos", this::listarPedidos);
    }

    public void guardarPedido(Context ctx) {
        ctx.contentType("application/json");
        Pedido pedido = ctx.bodyAsClass(Pedido.class);
        pedidoService.guardarPedido(pedido);
        ctx.status(201).json(pedido);
    }

    public void obtenerPedido(Context ctx) {
        String id = ctx.pathParam("id");
        ctx.json(pedidoService.obtenerPedido(id));
    }

    public void eliminarPedido(Context ctx) {
        String id = ctx.pathParam("id");
        pedidoService.eliminarPedido(id);
        ctx.status(200).result("Pedido eliminado con ID: " + id);
    }

    public void actualizarPedido(Context ctx) {
        String id = ctx.pathParam("id");
        Pedido pedido = ctx.bodyAsClass(Pedido.class);
        pedidoService.actualizarPedido(id, pedido);
        ctx.status(200).json(pedido);
    }

    public void listarPedidos(Context ctx) {
        ctx.json(pedidoService.obtenerPedidos());
    }
}
