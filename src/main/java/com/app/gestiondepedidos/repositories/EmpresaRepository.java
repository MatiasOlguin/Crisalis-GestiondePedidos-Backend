package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
    List<Empresa> findByBorradoFalse();
}
