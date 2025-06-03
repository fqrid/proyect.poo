package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/usuarios", this::crear);
        app.get("/usuarios/{id}", this::obtener);
        app.put("/usuarios/{id}", this::actualizar);
        app.delete("/usuarios/{id}", this::eliminar);
        app.get("/usuarios", this::listar);
    }

    public void crear(Context ctx) {
        Usuario usuario = ctx.bodyAsClass(Usuario.class);
        service.crear(usuario);
        ctx.status(201).json(usuario);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Usuario actualizado = ctx.bodyAsClass(Usuario.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Usuario eliminado");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
