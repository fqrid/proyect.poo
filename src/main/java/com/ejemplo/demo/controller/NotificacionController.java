// NotificacionController.java
package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Notificacion;
import com.ejemplo.demo.service.NotificacionService;
import io.javalin.Javalin;

public class NotificacionController {
    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    public void registrarRutas(Javalin app) {
        app.get("/notificaciones", ctx -> ctx.json(notificacionService.listar()));
        app.get("/notificaciones/{id}", ctx -> ctx.json(notificacionService.obtener(ctx.pathParam("id"))));
        app.post("/notificaciones", ctx -> ctx.json(notificacionService.crear(ctx.bodyAsClass(Notificacion.class))));
        app.put("/notificaciones/{id}", ctx -> ctx.json(notificacionService.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Notificacion.class))));
        app.delete("/notificaciones/{id}", ctx -> {
            notificacionService.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
