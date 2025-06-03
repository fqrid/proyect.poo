package com.ejemplo.demo.model;

public class Resena {
    private Long id;
    private String texto;
    private int calificacion;

    public Resena() {
    }

    public Resena(Long id, String texto, int calificacion) {
        this.id = id;
        this.texto = texto;
        this.calificacion = calificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
