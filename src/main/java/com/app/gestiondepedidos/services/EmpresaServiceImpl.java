package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Empresa;
import com.app.gestiondepedidos.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements IEmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> findAll() {
        return (List<Empresa>) empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> findById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }
}