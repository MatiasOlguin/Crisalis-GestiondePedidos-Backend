package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Usuario;
import com.app.gestiondepedidos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean autenticar (String username, String password){
        Usuario usuario= usuarioRepository.findByUsername(username).orElse(null);

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        boolean isMatched= encoder.matches(password,usuario.getPassword());

        if(usuario != null && isMatched){
            return true;
        }

        else
            return false;
    }
}