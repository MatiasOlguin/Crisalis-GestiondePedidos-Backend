package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.ServicioActivo;
import com.app.gestiondepedidos.repositories.ServicioActivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServicioActivoServiceImpl implements IServicioActivoService{
    @Autowired
    ServicioActivoRepository servicioActivoRepository;

    @Override
    @Transactional
    public Optional<ServicioActivo> findById(Long id) {
        return servicioActivoRepository.findById(id);
    }

    @Override
    @Transactional
    public ServicioActivo save(ServicioActivo servicioActivo) {
        return servicioActivoRepository.save(servicioActivo);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        servicioActivoRepository.deleteById(id);
    }
}
