package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Cliente;
import com.app.gestiondepedidos.models.Servicio;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public List<Cliente> findAll();
    public Optional<Cliente> findById(Long id);
    public Cliente save(Cliente cliente);
    public void delete(Long id);
    public void borradoLogico(Cliente cliente);

    public void activarServicio(Long id, Servicio servicio);
}
