package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Pedido;
import com.app.gestiondepedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements IPedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> findAll() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    @Transactional
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
}
