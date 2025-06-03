// Direccion.java
package com.ejemplo.demo.model;

public class Direccion {
    private String id;
    private String clienteId;
    private String calle;
    private String ciudad;
    private String codigoPostal;

    public Direccion() {
    }

    public Direccion(String id, String clienteId, String calle, String ciudad, String codigoPostal) {
        this.id = id;
        this.clienteId = clienteId;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
