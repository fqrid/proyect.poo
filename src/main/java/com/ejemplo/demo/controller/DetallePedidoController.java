// DetallePedidoController.java
package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.DetallePedido;
import com.ejemplo.demo.service.DetallePedidoService;
import io.javalin.Javalin;

public class DetallePedidoController {
    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    public void registrarRutas(Javalin app) {
        app.get("/detalle-pedidos", ctx -> ctx.json(detallePedidoService.listar()));
        app.get("/detalle-pedidos/{id}", ctx -> ctx.json(detallePedidoService.obtener(ctx.pathParam("id"))));
        app.post("/detalle-pedidos", ctx -> ctx.json(detallePedidoService.crear(ctx.bodyAsClass(DetallePedido.class))));
        app.put("/detalle-pedidos/{id}", ctx -> ctx.json(detallePedidoService.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(DetallePedido.class))));
        app.delete("/detalle-pedidos/{id}", ctx -> {
            detallePedidoService.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
