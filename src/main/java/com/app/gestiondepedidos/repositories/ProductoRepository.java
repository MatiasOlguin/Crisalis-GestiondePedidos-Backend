package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
    List<Producto> findByBorradoFalse();
}