package com.ejemplo.demo.model;

public class Comentario {
    private Long id;
    private String texto;
    private String autor;

    // Constructor vacío
    public Comentario() {
    }

    // Constructor con parámetros
    public Comentario(Long id, String texto, String autor) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
    }

    // Getters y Setters
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}