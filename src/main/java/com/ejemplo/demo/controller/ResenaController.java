package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Resena;
import com.ejemplo.demo.service.ResenaService;

public class ResenaController {

    private final ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/resenas", this::guardarResena);
        app.get("/resenas/{id}", this::obtenerResena);
        app.delete("/resenas/{id}", this::eliminarResena);
        app.put("/resenas/{id}", this::actualizarResena);
        app.get("/resenas", this::listarResenas);
    }

    public void guardarResena(Context ctx) {
        Resena resena = ctx.bodyAsClass(Resena.class);
        resenaService.guardarResena(resena);
        ctx.status(201).json(resena);
    }

    public void obtenerResena(Context ctx) {
        ctx.json(resenaService.obtenerResena(ctx.pathParam("id")));
    }

    public void eliminarResena(Context ctx) {
        resenaService.eliminarResena(ctx.pathParam("id"));
        ctx.status(200).result("Reseña eliminada");
    }

    public void actualizarResena(Context ctx) {
        Resena resena = ctx.bodyAsClass(Resena.class);
        resenaService.actualizarResena(ctx.pathParam("id"), resena);
        ctx.status(200).json(resena);
    }

    public void listarResenas(Context ctx) {
        ctx.json(resenaService.obtenerResenas());
    }
}
