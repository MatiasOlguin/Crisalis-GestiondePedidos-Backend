package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.ServicioActivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioActivoRepository extends CrudRepository<ServicioActivo, Long> {
}
