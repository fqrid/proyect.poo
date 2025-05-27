package com.ejemplo.demo.model;

import java.time.LocalDateTime;

public class Pago {
    private Long id;
    private Long pedidoId;
    private Long metodoId;
    private Double monto;
    private LocalDateTime fechaPago;
    private String estadoPago;

    // Referencias a las entidades relacionadas
    private Pedido pedido;
    private MetodoPago metodoPago;

    // Constructor vacío
    public Pago() {}

    // Constructor con parámetros
    public Pago(Long pedidoId, Long metodoId, Double monto, String estadoPago) {
        this.pedidoId = pedidoId;
        this.metodoId = metodoId;
        this.monto = monto;
        this.fechaPago = LocalDateTime.now();
        this.estadoPago = estadoPago;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getMetodoId() {
        return metodoId;
    }

    public void setMetodoId(Long metodoId) {
        this.metodoId = metodoId;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}