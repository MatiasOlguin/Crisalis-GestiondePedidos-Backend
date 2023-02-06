package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Usuario;

public interface IUsuarioService {
    public Usuario save(Usuario usuario);
    public Usuario autenticar (Usuario usuario);
    public boolean usernameEnUso(String username);
}