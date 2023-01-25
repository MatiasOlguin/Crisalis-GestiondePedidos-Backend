package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
