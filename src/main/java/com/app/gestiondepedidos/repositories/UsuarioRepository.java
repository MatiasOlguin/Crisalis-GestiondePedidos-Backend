package com.app.gestiondepedidos.repositories;

import com.app.gestiondepedidos.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository <Usuario, Long>{
    public Optional<Usuario> findByUsername(String username);
}
