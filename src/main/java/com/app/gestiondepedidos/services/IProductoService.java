package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Producto;
import java.util.List;
import java.util.Optional;

public interface IProductoService {
    public List<Producto> findAll();
    public Optional<Producto> findById(Long id);
    public Producto save(Producto producto);
    public void delete(Long id);
    public void borradoLogico(Producto producto);
    public void actualizarCantidad(Long id, int cantidad);
}