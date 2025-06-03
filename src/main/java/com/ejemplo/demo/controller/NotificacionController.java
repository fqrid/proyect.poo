package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.modelo.Mensaje;
import com.ejemplo.demo.modelo.Notificacion;
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
        ctx.contentType("application/json");
        Notificacion n = ctx.bodyAsClass(Notificacion.class);
        notificacionService.guardar(n);
        Mensaje<Notificacion> mensaje = new Mensaje<>("Notificación guardada", n);
        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtener(Context ctx) {
        String id = ctx.pathParam("id");
        Notificacion n = notificacionService.obtener(id);
        ctx.json(n);
    }

    public void eliminar(Context ctx) {
        String id = ctx.pathParam("id");
        notificacionService.eliminar(id);
        Mensaje<String> mensaje = new Mensaje<>("Notificación eliminada", id);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void actualizar(Context ctx) {
        String id = ctx.pathParam("id");
        Notificacion n = ctx.bodyAsClass(Notificacion.class);
        notificacionService.actualizar(id, n);
        Mensaje<Notificacion> mensaje = new Mensaje<>("Notificación actualizada", n);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listar(Context ctx) {
        ctx.json(notificacionService.listar());
    }
}
