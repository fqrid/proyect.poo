package com.ejemplo.demo.model;

public class Pedido {
    private Long id;
    private String descripcion;

    public Pedido() {}

    public Pedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
