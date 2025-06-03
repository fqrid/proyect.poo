package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Descuento;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.List;

public class DescuentoController {

    private static List<Descuento> descuentos = new ArrayList<>();
    private static long idCounter = 1;

    public static void main(String[] args) {
        // Obtener todos los descuentos
        get("/descuentos", (req, res) -> {
            res.type("application/json");
            return new com.google.gson.Gson().toJson(descuentos);
        });

        // Obtener un descuento por ID
        get("/descuentos/:id", (req, res) -> {
            long id = Long.parseLong(req.params(":id"));
            Descuento descuento = descuentos.stream()
                    .filter(d -> d.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (descuento == null) {
                res.status(404);
                return "Descuento no encontrado";
            }
            res.type("application/json");
            return new com.google.gson.Gson().toJson(descuento);
        });

        // Crear un nuevo descuento
        post("/descuentos", (req, res) -> {
            Descuento nuevo = new com.google.gson.Gson().fromJson(req.body(), Descuento.class);
            nuevo.setId(idCounter++);
            descuentos.add(nuevo);
            res.status(201);
            return new com.google.gson.Gson().toJson(nuevo);
        });

        // Actualizar un descuento existente
        put("/descuentos/:id", (req, res) -> {
            long id = Long.parseLong(req.params(":id"));
            Descuento actualizado = new com.google.gson.Gson().fromJson(req.body(), Descuento.class);
            Descuento existente = descuentos.stream()
                    .filter(d -> d.getId() == id)
                    .findFirst()
                    .orElse(null);
            if (existente == null) {
                res.status(404);
                return "Descuento no encontrado";
            }
            existente.setPorcentaje(actualizado.getPorcentaje());
            existente.setFechaInicio(actualizado.getFechaInicio());
            existente.setFechaFin(actualizado.getFechaFin());
            return new com.google.gson.Gson().toJson(existente);
        });

        // Eliminar un descuento
        delete("/descuentos/:id", (req, res) -> {
            long id = Long.parseLong(req.params(":id"));
            boolean eliminado = descuentos.removeIf(d -> d.getId() == id);
            if (!eliminado) {
                res.status(404);
                return "Descuento no encontrado";
            }
            return "Descuento eliminado";
        });
    }
}
