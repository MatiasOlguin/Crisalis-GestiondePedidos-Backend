package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Long> {
    List<Servicio> findByBorradoFalse();
}