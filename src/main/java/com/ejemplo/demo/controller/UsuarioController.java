package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/usuarios", this::guardarUsuario);
        app.get("/usuarios/{id}", this::obtenerUsuario);
        app.delete("/usuarios/{id}", this::eliminarUsuario);
        app.put("/usuarios/{id}", this::actualizarUsuario);
        app.get("/usuarios", this::listarUsuarios);
    }

    public void guardarUsuario(Context ctx) {
        Usuario usuario = ctx.bodyAsClass(Usuario.class);
        usuarioService.guardarUsuario(usuario);
        ctx.status(201).json(usuario);
    }

    public void obtenerUsuario(Context ctx) {
        ctx.json(usuarioService.obtenerUsuario(ctx.pathParam("id")));
    }

    public void eliminarUsuario(Context ctx) {
        usuarioService.eliminarUsuario(ctx.pathParam("id"));
        ctx.status(200).result("Usuario eliminado");
    }

    public void actualizarUsuario(Context ctx) {
        Usuario usuario = ctx.bodyAsClass(Usuario.class);
        usuarioService.actualizarUsuario(ctx.pathParam("id"), usuario);
        ctx.status(200).json(usuario);
    }

    public void listarUsuarios(Context ctx) {
        ctx.json(usuarioService.obtenerUsuarios());
    }
}
