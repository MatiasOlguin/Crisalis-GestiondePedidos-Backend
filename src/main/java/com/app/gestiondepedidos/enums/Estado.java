package com.app.gestiondepedidos.enums;

public enum Estado {
    EN_REVISION("En revisión"),
    ACEPTADO("Aceptado"),
    CANCELADO("Cancelado");

    private String estado;

    Estado(String estado){
        this.estado=estado;
    }

    public String getEstado() {
        return estado;
    }
}
