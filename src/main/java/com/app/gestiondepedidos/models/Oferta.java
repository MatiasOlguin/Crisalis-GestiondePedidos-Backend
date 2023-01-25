package com.app.gestiondepedidos.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ofertas")
@DiscriminatorColumn(name = "oferta_tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Oferta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @Column(name = "monto_base")
    private Double montoBase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMontoBase() {
        return montoBase;
    }

    public void setMontoBase(Double montoBase) {
        this.montoBase = montoBase;
    }
}