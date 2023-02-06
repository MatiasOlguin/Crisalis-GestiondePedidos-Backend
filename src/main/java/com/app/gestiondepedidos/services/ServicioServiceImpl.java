package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Producto;
import com.app.gestiondepedidos.models.Servicio;
import com.app.gestiondepedidos.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements IServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> findAll() {
        return servicioRepository.findByBorradoFalse();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Servicio> findById(Long id) {
        return servicioRepository.findById(id);
    }

    @Override
    @Transactional
    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    @Transactional
    public void borradoLogico(Servicio servicio) {
        servicio.setBorrado(true);
        servicioRepository.save(servicio);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        servicioRepository.deleteById(id);
    }
}