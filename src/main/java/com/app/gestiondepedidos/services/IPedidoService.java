package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Pedido;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {
    public List<Pedido> findAll();
    public Optional<Pedido> findById(Long id);
    public Pedido save(Pedido pedido);
    public void delete(Long id);
}
