package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Categoria;
import com.ejemplo.demo.service.CategoriaService;
import io.javalin.Javalin;

public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.get("/categorias", ctx -> ctx.json(service.listar()));
        app.get("/categorias/{id}", ctx -> ctx.json(service.obtener(ctx.pathParam("id"))));
        app.post("/categorias", ctx -> ctx.json(service.crear(ctx.bodyAsClass(Categoria.class))));
        app.put("/categorias/{id}", ctx -> ctx.json(service.actualizar(ctx.pathParam("id"), ctx.bodyAsClass(Categoria.class))));
        app.delete("/categorias/{id}", ctx -> {
            service.eliminar(ctx.pathParam("id"));
            ctx.status(204);
        });
    }
}
