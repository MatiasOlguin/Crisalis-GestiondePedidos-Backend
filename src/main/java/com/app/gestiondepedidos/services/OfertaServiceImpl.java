package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Oferta;
import com.app.gestiondepedidos.models.Producto;
import com.app.gestiondepedidos.models.Servicio;
import com.app.gestiondepedidos.repositories.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OfertaServiceImpl implements IOfertaService{
    @Autowired
    private OfertaRepository ofertaRepository;

    @Override
    @Transactional(readOnly = true)
    public Producto findByIdProducto(Long id){
        return ofertaRepository.findByIdProducto(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Servicio findByIdServicio(Long id){ return ofertaRepository.findByIdServicio(id); }

    @Override
    @Transactional
    public Oferta save(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ofertaRepository.deleteById(id);
    }

    @Override
    public List<Producto> findAllProductos() {
        return ofertaRepository.findAllProductos();
    }

    @Override
    public List<Servicio> findAllServicios() {return ofertaRepository.findAllServicios();}
}
