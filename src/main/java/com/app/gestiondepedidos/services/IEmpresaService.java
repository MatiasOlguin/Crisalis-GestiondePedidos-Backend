package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Empresa;
import java.util.List;
import java.util.Optional;

public interface IEmpresaService {
    public List<Empresa> findAll();
    public Optional<Empresa> findById(Long id);
    public Empresa save(Empresa empresa);
    public void delete(Long id);
    public void borradoLogico(Empresa empresa);
}
