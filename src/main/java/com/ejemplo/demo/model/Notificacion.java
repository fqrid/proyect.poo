// Notificacion.java
package com.ejemplo.demo.model;

public class Notificacion {
    private String id;
    private String usuarioId;
    private String mensaje;
    private boolean leida;

    public Notificacion() {
    }

    public Notificacion(String id, String usuarioId, String mensaje, boolean leida) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.mensaje = mensaje;
        this.leida = leida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }
}
