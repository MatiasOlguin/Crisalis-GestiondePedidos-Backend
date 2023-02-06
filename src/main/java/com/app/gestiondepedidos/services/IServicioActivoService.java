package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Servicio;
import com.app.gestiondepedidos.models.ServicioActivo;

import java.util.List;
import java.util.Optional;

public interface IServicioActivoService {

    public Optional<ServicioActivo> findById(Long id);

    public ServicioActivo save(ServicioActivo servicio);

    public void delete(Long id);
}
