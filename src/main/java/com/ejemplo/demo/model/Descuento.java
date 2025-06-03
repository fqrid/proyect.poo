package com.ejemplo.demo.model;

public class Descuento {
    private Long id;
    private String descripcion;
    private Double porcentaje;

    public Descuento() {
    }

    public Descuento(Long id, String descripcion, Double porcentaje) {
        this.id = id;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
}