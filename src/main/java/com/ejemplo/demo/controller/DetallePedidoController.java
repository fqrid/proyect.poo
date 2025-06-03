package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.DetallePedido;
import com.ejemplo.demo.service.DetallePedidoService;
import io.javalin.Javalin;

public class DetallePedidoController {
    private final DetallePedidoService service;

    public DetallePedidoController(DetallePedidoService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.get("/detalles-pedido", ctx -> ctx.json(service.listar()));
        app.get("/detalles-pedido/{id}", ctx -> ctx.json(service.obtener(ctx.pathParam("id"))));
        app.post("/detalles-pedido", ctx -> ctx.json(service.crear(ctx.bodyAsClass(DetallePedido.class))));
        app.put("/detalles-pedido/{id}", ctx -> ctx.json(service.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(DetallePedido.class))));
        app.delete("/detalles-pedido/{id}", ctx -> {
            service.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
