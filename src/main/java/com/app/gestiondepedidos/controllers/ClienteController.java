package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.dto.ClienteDTO;
import com.app.gestiondepedidos.dto.ClienteMapper;
import com.app.gestiondepedidos.models.Cliente;
import com.app.gestiondepedidos.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("")
    public List<ClienteDTO> index() {
        List<Cliente> temp=clienteService.findAll();
        List<ClienteDTO> lista= new ArrayList<>();

        for(int i = 0; i < temp.size(); i++){
            ClienteDTO aux= ClienteMapper.crearClienteDTO(temp.get(i));
            lista.add(aux);
        }

        return lista;
    }

    @GetMapping("{id}")
    public Cliente show (@PathVariable Long id){
        return clienteService.findById(id).orElse(null);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create (@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente clienteActual= clienteService.findById(id).orElse(null);

        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setDni(cliente.getDni());

        return clienteService.save(clienteActual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id){
        clienteService.delete(id);
    }
}