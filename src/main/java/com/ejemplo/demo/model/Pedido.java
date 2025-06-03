package com.ejemplo.demo.model;

public class Pedido {
    private String id;
    private String clienteId;
    private String fecha;
    private String estado;

    public Pedido() {}

    public Pedido(String id, String clienteId, String fecha, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}