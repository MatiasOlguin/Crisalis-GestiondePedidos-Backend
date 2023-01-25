package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public List<Usuario> findAll();
    public Optional<Usuario> findByUsername(String username);

    public Usuario save(Usuario usuario);

    public boolean autenticar (String username, String password);
}