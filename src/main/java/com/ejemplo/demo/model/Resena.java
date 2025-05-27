package com.ejemplo.demo.model;

import java.time.LocalDateTime;

public class Resena {
    private Long id;
    private Long productoId;
    private Long usuarioId;
    private Integer calificacion;
    private String comentario;
    private LocalDateTime fechaResena;

    public Resena() {}

    public Resena(Long productoId, Long usuarioId, Integer calificacion, String comentario) {
        this.productoId = productoId;
        this.usuarioId = usuarioId;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaResena = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Integer getCalificacion() { return calificacion; }
    public void setCalificacion(Integer calificacion) { this.calificacion = calificacion; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public LocalDateTime getFechaResena() { return fechaResena; }
    public void setFechaResena(LocalDateTime fechaResena) { this.fechaResena = fechaResena; }
}