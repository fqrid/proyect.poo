package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Categoria;
import com.ejemplo.demo.service.CategoriaService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/categorias", this::crear);
        app.get("/categorias/{id}", this::obtener);
        app.put("/categorias/{id}", this::actualizar);
        app.delete("/categorias/{id}", this::eliminar);
        app.get("/categorias", this::listar);
    }

    public void crear(Context ctx) {
        Categoria categoria = ctx.bodyAsClass(Categoria.class);
        service.crear(categoria);
        ctx.status(201).json(categoria);
    }

    public void obtener(Context ctx) {
        ctx.json(service.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Categoria categoria = ctx.bodyAsClass(Categoria.class);
        service.actualizar(ctx.pathParam("id"), categoria);
        ctx.status(200).json(categoria);
    }

    public void eliminar(Context ctx) {
        service.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Categoría eliminada");
    }

    public void listar(Context ctx) {
        ctx.json(service.listar());
    }
}
