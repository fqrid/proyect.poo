package com.ejemplo.demo.model;

public class CategoriaSecundaria {
    private String id;
    private String nombre;
    private String categoriaId;

    public CategoriaSecundaria() {
    }

    public CategoriaSecundaria(String id, String nombre, String categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.categoriaId = categoriaId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }
}