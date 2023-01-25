package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
