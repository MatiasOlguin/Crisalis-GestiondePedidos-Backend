package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Item;
import java.util.List;

public interface IItemService {
    public List<Item> findAll();
    public Item findById(Long id);
    public Item save(Item item);
    public void delete(Long id);
}
