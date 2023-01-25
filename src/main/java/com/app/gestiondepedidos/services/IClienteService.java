package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public List<Cliente> findAll();
    public Optional<Cliente> findById(Long id);
    public Cliente save(Cliente cliente);
    public void delete(Long id);
}
