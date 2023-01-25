package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Oferta;
import com.app.gestiondepedidos.models.Producto;
import com.app.gestiondepedidos.models.Servicio;

import java.util.List;
import java.util.Optional;

public interface IOfertaService {
    public Producto findByIdProducto(Long id);
    public Servicio findByIdServicio(Long id);
    public Oferta save(Oferta oferta);
    public void delete(Long id);
    public List<Producto> findAllProductos();
    public List<Servicio> findAllServicios();
}
