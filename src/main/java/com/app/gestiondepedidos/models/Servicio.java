package com.app.gestiondepedidos.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="servicios")
public class Servicio extends Oferta implements Serializable{
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}