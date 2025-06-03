package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class InicioController {

    public void configurarRutas(Javalin app) {
        app.get("/", this::mensajeInicio);
    }

    private void mensajeInicio(Context ctx) {
        ctx.result("¡Bienvenido a la API de ejemplo!");
    }
}
