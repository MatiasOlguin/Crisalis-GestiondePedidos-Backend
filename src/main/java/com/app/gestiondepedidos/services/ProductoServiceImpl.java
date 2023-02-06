package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Producto;
import com.app.gestiondepedidos.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return productoRepository.findByBorradoFalse();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void borradoLogico(Producto producto) {
        producto.setBorrado(true);
        productoRepository.save(producto);
    }

     @Override
     @Transactional
     public void actualizarCantidad(Long id, int cantidad){
        Producto producto= findById(id).get();
        producto.setCantidad(cantidad);
        save(producto);
    }
}
