package com.app.gestiondepedidos.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedidos_items")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "oferta_id")
    private Oferta oferta;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Oferta getOferta() { return oferta;}

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }
}
