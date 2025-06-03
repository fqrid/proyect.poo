// Comentario.java
package com.ejemplo.demo.model;

public class Comentario {
    private String id;
    private String productoId;
    private String usuarioId;
    private String contenido;

    public Comentario() {
    }

    public Comentario(String id, String productoId, String usuarioId, String contenido) {
        this.id = id;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
        this.contenido = contenido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
