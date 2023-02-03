package com.app.gestiondepedidos.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="productos")
public class Producto extends Oferta implements Serializable{
    private String marca;
    private String modelo;
    private Integer cantidad;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}