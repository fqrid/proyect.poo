package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.ejemplo.demo.model.ItemCarrito;
import com.ejemplo.demo.service.ItemCarritoService;

import java.util.List;

/**
 * Controlador REST para ItemCarrito, usando Javalin.
 */
public class ItemCarritoController {

    private final ItemCarritoService itemCarritoService;

    public ItemCarritoController(ItemCarritoService itemCarritoService) {
        this.itemCarritoService = itemCarritoService;
    }

    /**
     * Registra las rutas de Javalin para CRUD de ItemCarrito.
     */
    public void configurarRutas(Javalin app) {
        app.post("/items-carrito", this::guardarItem);
        app.get("/items-carrito/{id}", this::obtenerItem);
        app.get("/items-carrito", this::listarItems);
        app.put("/items-carrito/{id}", this::actualizarItem);
        app.delete("/items-carrito/{id}", this::eliminarItem);
    }

    private void guardarItem(Context ctx) {
        ctx.contentType("application/json");
        ItemCarrito item = ctx.bodyAsClass(ItemCarrito.class);
        ItemCarrito creado = itemCarritoService.crear(item);
        ctx.status(201).json(creado);
    }

    private void obtenerItem(Context ctx) {
        String id = ctx.pathParam("id");             // ID como String
        ItemCarrito item = itemCarritoService.obtenerPorId(id);
        ctx.json(item);
    }

    private void listarItems(Context ctx) {
        List<ItemCarrito> lista = itemCarritoService.obtenerTodos();
        ctx.json(lista);
    }

    private void actualizarItem(Context ctx) {
        String id = ctx.pathParam("id");
        ItemCarrito nuevo = ctx.bodyAsClass(ItemCarrito.class);
        ItemCarrito actualizado = itemCarritoService.actualizar(id, nuevo);
        ctx.json(actualizado);
    }

    private void eliminarItem(Context ctx) {
        String id = ctx.pathParam("id");
        itemCarritoService.eliminar(id);
        ctx.status(204); // No Content
    }
}
