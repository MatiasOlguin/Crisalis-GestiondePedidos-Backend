package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.models.Usuario;
import com.app.gestiondepedidos.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario){
        Usuario usuarioAutenticado= usuarioService.autenticar(usuario);

        if(usuarioAutenticado != null){
            return new ResponseEntity<>(usuarioAutenticado, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        if(!usuarioService.usernameEnUso(usuario.getUsername())){
            usuarioService.save(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}