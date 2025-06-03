package com.ejemplo.demo.model;

public class Direccion {
    private Integer id;
    private String ciudad;
    private String direccion;

    public Direccion() {}

    public Direccion(Integer id, String ciudad, String direccion) {
        this.id = id;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}