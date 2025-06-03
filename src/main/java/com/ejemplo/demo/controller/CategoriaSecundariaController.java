package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.CategoriaSecundaria;
import com.ejemplo.demo.service.CategoriaSecundariaService;
import org.jetbrains.annotations.NotNull;

public class CategoriaSecundariaController {

    private final CategoriaSecundariaService servicio;

    public CategoriaSecundariaController(CategoriaSecundariaService servicio) {
        this.servicio = servicio;
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
        servicio.crear(categoria);
        ctx.status(201).json(categoria);
    }

    public void obtener(Context ctx) {
        String id = ctx.pathParam("id");
        ctx.json(servicio.obtener(id));
    }

    public void actualizar(Context ctx) {
        String id = ctx.pathParam("id");
        CategoriaSecundaria actualizada = ctx.bodyAsClass(CategoriaSecundaria.class);
        servicio.actualizar(id, actualizada);
        ctx.status(200).json(actualizada);
    }

    public void eliminar(Context ctx) {
        String id = ctx.pathParam("id");
        servicio.eliminar(id);
        ctx.status(200).result("Categoría secundaria eliminada");
    }

    public void listar(@NotNull Context ctx) {
        ctx.json(servicio.listar());
    }
}
