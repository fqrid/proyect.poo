// Pago.java
package com.ejemplo.demo.model;

public class Pago {
    private String id;
    private String pedidoId;
    private double monto;
    private String metodo;

    public Pago() {
    }

    public Pago(String id, String pedidoId, double monto, String metodo) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.monto = monto;
        this.metodo = metodo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
}
