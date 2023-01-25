package com.app.gestiondepedidos.controllers;


import com.app.gestiondepedidos.models.Usuario;
import com.app.gestiondepedidos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario){
        boolean flag= usuarioService.autenticar(usuario.getUsername(),usuario.getPassword());


        if(flag){
            return new ResponseEntity<>("Login exitoso", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Credenciales invalidas", HttpStatus.UNAUTHORIZED);
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
//    }

//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody User user) {
//        userService.register(user);
//        return new ResponseEntity<>("Registro exitoso", HttpStatus.OK);
//    }
}
