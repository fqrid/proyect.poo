package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Notificacion;
import com.ejemplo.demo.service.NotificacionService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class NotificacionController {

    private final NotificacionService service;

    public NotificacionController(NotificacionService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/notificaciones", this::crear);
        app.get("/notificaciones/{id}", this::obtener);
        app.put("/notificaciones/{id}", this::actualizar);
        app.delete("/notificaciones/{id}", this::eliminar);
        app.get("/notificaciones", this::listar);
    }

    public void crear(Context ctx) {
        Notificacion n = ctx.bodyAsClass(Notificacion.class);
        service.crear(n);
        ctx.status(201).json(n);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Notificacion actualizado = ctx.bodyAsClass(Notificacion.class);
        service.actualizar(ctx.pathParam("id"), actualizado);
        ctx.status(200).json(actualizado);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Notificación eliminada");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
