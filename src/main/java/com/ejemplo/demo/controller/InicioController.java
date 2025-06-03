package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class InicioController {

    public void configurarRutas(Javalin app) {
        app.get("/", this::inicio);
    }

    private void inicio(Context ctx) {
        ctx.result("¡Holaaaaaa, Javalin está funcionando!");
    }
}
