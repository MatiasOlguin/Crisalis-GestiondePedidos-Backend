package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Servicio;
import java.util.List;
import java.util.Optional;

public interface IServicioService {
    public List<Servicio> findAll();
    public Optional<Servicio> findById(Long id);
    public Servicio save(Servicio servicio);
    public void delete(Long id);
    public void borradoLogico(Servicio servicio);
}
