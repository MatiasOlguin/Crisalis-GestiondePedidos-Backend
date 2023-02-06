package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.dto.ClienteDTO;
import com.app.gestiondepedidos.dto.ClienteMapper;
import com.app.gestiondepedidos.models.Cliente;
import com.app.gestiondepedidos.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> index() {
        List<Cliente> temp=clienteService.findAll();

        if (temp.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<ClienteDTO> clientes= new ArrayList<>();
        for(int i = 0; i < temp.size(); i++){
            ClienteDTO aux= ClienteMapper.crearClienteDTO(temp.get(i));
            clientes.add(aux);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDTO> show (@PathVariable Long id){
        Optional<Cliente> clienteOpt= clienteService.findById(id);

        if (!clienteOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ClienteDTO cliente= ClienteMapper.crearClienteDTO(clienteOpt.get());

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> create (@RequestBody Cliente cliente){
        Cliente clienteCreado= clienteService.save(cliente);
        return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Long id){
        Optional<Cliente> clienteOpt= clienteService.findById(id);

        if (!clienteOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Cliente clienteActual= clienteOpt.get();

        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setDni(cliente.getDni());

        clienteService.save(clienteActual);

        return new ResponseEntity<>(clienteActual, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        Optional<Cliente> clienteOpt= clienteService.findById(id);

        if (!clienteOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clienteService.borradoLogico(clienteOpt.get());

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete (@PathVariable Long id){
//        Optional<Cliente> clienteOpt= clienteService.findById(id);
//
//        if (!clienteOpt.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        clienteService.delete(id);
//
//        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}