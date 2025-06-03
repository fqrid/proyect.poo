package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.CategoriaSecundaria;
import com.ejemplo.demo.service.CategoriaSecundariaService;
import io.javalin.Javalin;

public class CategoriaSecundariaController {
    private final CategoriaSecundariaService service;

    public CategoriaSecundariaController(CategoriaSecundariaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.get("/categorias-secundarias", ctx -> ctx.json(service.listar()));
        app.get("/categorias-secundarias/{id}", ctx -> ctx.json(service.obtener(ctx.pathParam("id"))));
        app.post("/categorias-secundarias", ctx -> ctx.json(service.crear(ctx.bodyAsClass(CategoriaSecundaria.class))));
        app.put("/categorias-secundarias/{id}", ctx -> ctx.json(service.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(CategoriaSecundaria.class))));
        app.delete("/categorias-secundarias/{id}", ctx -> {
            service.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
