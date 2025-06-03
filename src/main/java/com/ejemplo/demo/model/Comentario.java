package com.ejemplo.demo.model;

public class Comentario {
    private Integer id;
    private String texto;

    public Comentario() {
    }

    public Comentario(Integer id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}