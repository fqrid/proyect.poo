package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Categoria;
import com.ejemplo.demo.service.CategoriaService;

public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
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
        categoriaService.crear(categoria);
        ctx.status(201).json(categoria);
    }

    public void obtener(Context ctx) {
        ctx.json(categoriaService.obtener(ctx.pathParam("id")));
    }

    public void actualizar(Context ctx) {
        Categoria actualizada = ctx.bodyAsClass(Categoria.class);
        categoriaService.actualizar(ctx.pathParam("id"), actualizada);
        ctx.status(200).json(actualizada);
    }

    public void eliminar(Context ctx) {
        categoriaService.eliminar(ctx.pathParam("id"));
        ctx.status(200).result("Categoría eliminada");
    }

    public void listar(Context ctx) {
        ctx.json(categoriaService.listar());
    }
}