package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Oferta;
import com.app.gestiondepedidos.models.Producto;
import com.app.gestiondepedidos.models.Servicio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfertaRepository extends CrudRepository<Oferta, Long> {
    @Query(value = "SELECT * FROM ofertas WHERE oferta_tipo='producto'", nativeQuery = true)
    public List<Producto> findAllProductos();

    @Query(value = "SELECT * FROM ofertas WHERE oferta_tipo='servicio'", nativeQuery = true)
    public List<Servicio> findAllServicios();
    @Query(value = "SELECT * FROM ofertas WHERE oferta_tipo='producto' AND id= :id", nativeQuery = true)
    public Producto findByIdProducto(Long id);
    @Query(value = "SELECT * FROM ofertas WHERE oferta_tipo='servicio' AND id= :id", nativeQuery = true)
    public Servicio findByIdServicio(Long id);
}

