package com.app.gestiondepedidos.dto;

import com.app.gestiondepedidos.enums.Estado;
import com.app.gestiondepedidos.models.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDTO {
    private Long id;
    private Date createAt;
    private String estado;
    private Double total;
    private ClienteNombreCompletoDTO cliente;
    private List<Item> items;

    public PedidoDTO() {
        items = new ArrayList<>();
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ClienteNombreCompletoDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteNombreCompletoDTO cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
