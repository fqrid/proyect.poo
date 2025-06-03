// InicioController.java
package com.ejemplo.demo.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class InicioController {

    public void registrarRutas(Javalin app) {
        app.get("/", this::mostrarMensaje);
    }

    private void mostrarMensaje(Context ctx) {
        ctx.result("Bienvenido a la API de ejemplo.");
    }
}
