package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Cliente;
import com.ejemplo.demo.service.ClienteService;
import io.javalin.Javalin;

public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.get("/clientes", ctx -> ctx.json(service.listar()));
        app.get("/clientes/{id}", ctx -> ctx.json(service.obtener(ctx.pathParam("id"))));
        app.post("/clientes", ctx -> ctx.json(service.crear(ctx.bodyAsClass(Cliente.class))));
        app.put("/clientes/{id}", ctx -> ctx.json(service.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Cliente.class))));
        app.delete("/clientes/{id}", ctx -> {
            service.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
