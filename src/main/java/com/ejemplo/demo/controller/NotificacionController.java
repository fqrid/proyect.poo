package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Notificacion;
import com.ejemplo.demo.service.NotificacionService;

public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/notificaciones", this::guardar);
        app.get("/notificaciones/{id}", this::obtener);
        app.delete("/notificaciones/{id}", this::eliminar);
        app.put("/notificaciones/{id}", this::actualizar);
        app.get("/notificaciones", this::listar);
    }

    public void guardar(Context ctx) {
        Notificacion n = ctx.bodyAsClass(Notificacion.class);
        notificacionService.guardarNotificacion(n);
        ctx.status(201).json(n);
    }

    public void obtener(Context ctx) {
        ctx.json(notificacionService.obtenerNotificacion(ctx.pathParam("id")));
    }

    public void eliminar(Context ctx) {
        notificacionService.eliminarNotificacion(ctx.pathParam("id"));
        ctx.status(200).result("Notificación eliminada");
    }

    public void actualizar(Context ctx) {
        Notificacion n = ctx.bodyAsClass(Notificacion.class);
        notificacionService.actualizarNotificacion(ctx.pathParam("id"), n);
        ctx.status(200).json(n);
    }

    public void listar(Context ctx) {
        ctx.json(notificacionService.obtenerNotificaciones());
    }
}
