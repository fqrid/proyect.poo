package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.CategoriaSecundaria;
import com.ejemplo.demo.service.CategoriaSecundariaService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class CategoriaSecundariaController {

    private final CategoriaSecundariaService service;

    public CategoriaSecundariaController(CategoriaSecundariaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/categorias-secundarias", this::crear);
        app.get("/categorias-secundarias/{id}", this::obtener);
        app.put("/categorias-secundarias/{id}", this::actualizar);
        app.delete("/categorias-secundarias/{id}", this::eliminar);
        app.get("/categorias-secundarias", this::listar);
    }

    public void crear(Context ctx) {
        CategoriaSecundaria categoria = ctx.bodyAsClass(CategoriaSecundaria.class);
        service.crear(categoria);
        ctx.status(201).json(categoria);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        CategoriaSecundaria categoria = ctx.bodyAsClass(CategoriaSecundaria.class);
        service.actualizar(ctx.pathParam("id"), categoria);
        ctx.status(200).json(categoria);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Categoría secundaria eliminada");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
