// Resena.java
package com.ejemplo.demo.model;

public class Resena {
    private String id;
    private String productoId;
    private String usuarioId;
    private int calificacion;
    private String comentario;

    public Resena() {
    }

    public Resena(String id, String productoId, String usuarioId, int calificacion, String comentario) {
        this.id = id;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
        this.calificacion = calificacion;
        this.comentario = comentario;
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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
