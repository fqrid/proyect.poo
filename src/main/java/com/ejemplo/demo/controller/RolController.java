package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Rol;
import com.ejemplo.demo.service.RolService;

public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/roles", this::guardarRol);
        app.get("/roles/{id}", this::obtenerRol);
        app.delete("/roles/{id}", this::eliminarRol);
        app.put("/roles/{id}", this::actualizarRol);
        app.get("/roles", this::listarRoles);
    }

    public void guardarRol(Context ctx) {
        Rol rol = ctx.bodyAsClass(Rol.class);
        rolService.guardarRol(rol);
        ctx.status(201).json(rol);
    }

    public void obtenerRol(Context ctx) {
        ctx.json(rolService.obtenerRol(ctx.pathParam("id")));
    }

    public void eliminarRol(Context ctx) {
        rolService.eliminarRol(ctx.pathParam("id"));
        ctx.status(200).result("Rol eliminado");
    }

    public void actualizarRol(Context ctx) {
        Rol rol = ctx.bodyAsClass(Rol.class);
        rolService.actualizarRol(ctx.pathParam("id"), rol);
        ctx.status(200).json(rol);
    }

    public void listarRoles(Context ctx) {
        ctx.json(rolService.obtenerRoles());
    }
}
