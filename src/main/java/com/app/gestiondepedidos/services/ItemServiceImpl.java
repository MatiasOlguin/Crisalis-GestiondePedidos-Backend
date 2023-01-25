package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Item;
import com.app.gestiondepedidos.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements IItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
