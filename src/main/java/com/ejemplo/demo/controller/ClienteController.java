package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Cliente;
import com.ejemplo.demo.service.ClienteService;

public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/clientes", this::crear);
        app.get("/clientes/{id}", this::obtener);
        app.put("/clientes/{id}", this::actualizar);
        app.delete("/clientes/{id}", this::eliminar);
        app.get("/clientes", this::listar);
    }

    public void crear(Context ctx) {
        Cliente cliente = ctx.bodyAsClass(Cliente.class);
        service.crear(cliente);
        ctx.status(201).json(cliente);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Cliente actualizado = ctx.bodyAsClass(Cliente.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Cliente eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}