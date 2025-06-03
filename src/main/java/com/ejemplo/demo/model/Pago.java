package com.ejemplo.demo.model;

public class Pago {
    private String id;
    private double monto;
    private String metodoId;
    private String estado;

    public Pago() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoId() {
        return metodoId;
    }

    public void setMetodoId(String metodoId) {
        this.metodoId = metodoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
