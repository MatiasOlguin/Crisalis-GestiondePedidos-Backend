package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Usuario;
import com.app.gestiondepedidos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) { return usuarioRepository.save(usuario);}

    @Override
    @Transactional(readOnly = true)
    public Usuario autenticar(Usuario usuario) {
        Optional<Usuario> optUsuario=usuarioRepository.findByUsername(usuario.getUsername());

        if(optUsuario.isPresent()){
            Usuario usuarioAutenticar= optUsuario.get();
            if(usuarioAutenticar.getPassword().equals(usuario.getPassword()))
                return usuarioAutenticar;
        }
        return null;
    }

    @Override
    public boolean usernameEnUso(String username) {
        Optional<Usuario> optUsuario = usuarioRepository.findByUsername(username);
        return optUsuario.isPresent();
    }


}
