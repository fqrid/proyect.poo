package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.Inventario;
import com.ejemplo.demo.service.InventarioService;

public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/inventarios", this::guardarInventario);
        app.get("/inventarios/{id}", this::obtenerInventario);
        app.delete("/inventarios/{id}", this::eliminarInventario);
        app.put("/inventarios/{id}", this::actualizarInventario);
        app.get("/inventarios", this::listarInventarios);
    }

    public void guardarInventario(Context ctx) {
        ctx.contentType("application/json");
        Inventario inventario = ctx.bodyAsClass(Inventario.class);
        inventarioService.guardarInventario(inventario);
        ctx.status(201).json(inventario);
    }

    public void obtenerInventario(Context ctx) {
        String id = ctx.pathParam("id");
        ctx.json(inventarioService.obtenerInventario(id));
    }

    public void eliminarInventario(Context ctx) {
        String id = ctx.pathParam("id");
        inventarioService.eliminarInventario(id);
        ctx.status(200).result("Inventario eliminado con ID: " + id);
    }

    public void actualizarInventario(Context ctx) {
        String id = ctx.pathParam("id");
        Inventario inventario = ctx.bodyAsClass(Inventario.class);
        inventarioService.actualizarInventario(id, inventario);
        ctx.status(200).json(inventario);
    }

    public void listarInventarios(Context ctx) {
        ctx.json(inventarioService.obtenerInventarios());
    }
}
