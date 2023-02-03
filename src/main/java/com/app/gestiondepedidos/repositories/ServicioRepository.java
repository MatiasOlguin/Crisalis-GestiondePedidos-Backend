package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Long> { }