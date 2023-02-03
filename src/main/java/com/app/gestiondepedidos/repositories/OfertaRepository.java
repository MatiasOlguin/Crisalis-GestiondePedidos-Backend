package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Oferta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRepository extends CrudRepository<Oferta, Long> { }