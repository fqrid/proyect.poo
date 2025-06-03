package com.ejemplo.demo.model;

public class CarritoCompra {
    private String id;
    private String clienteId;

    public CarritoCompra() {
    }

    public CarritoCompra(String id, String clienteId) {
        this.id = id;
        this.clienteId = clienteId;
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
}