package com.ejemplo.demo.model;

public class Comentario {
    private Long id;
    private String contenido;

    public Comentario() {}

    public Comentario(String contenido) {
        this.contenido = contenido;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
}
