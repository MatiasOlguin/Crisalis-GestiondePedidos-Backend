package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByBorradoFalse();
}