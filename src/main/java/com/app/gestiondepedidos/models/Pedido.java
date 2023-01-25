package com.app.gestiondepedidos.models;

import com.app.gestiondepedidos.enums.Estado;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date createAt;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "monto_total")
    private Double montoTotal;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name="pedido_id")
    private List<Item> items;

    public Pedido(){
        this.items= new ArrayList<>();
        this.estado= Estado.EN_REVISION;
    }

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
