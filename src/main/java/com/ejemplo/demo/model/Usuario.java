package com.ejemplo.demo.model;

public class Usuario {
    private String id;
    private String nombre;
    private String correo;
    private String rolId;

    public Usuario() {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }
}
