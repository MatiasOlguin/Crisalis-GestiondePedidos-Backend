package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.dto.PedidoDTO;
import com.app.gestiondepedidos.dto.PedidoMapper;
import com.app.gestiondepedidos.models.Pedido;
import com.app.gestiondepedidos.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping
    public List<PedidoDTO> index() {
        List<Pedido> temp = pedidoService.findAll();
        List<PedidoDTO> lista = new ArrayList<>();

        for (int i = 0; i < temp.size(); i++) {
            PedidoDTO aux = PedidoMapper.crearPedidoDTO(temp.get(i));
            lista.add(aux);
        }

        return lista;
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoDTO> show(@PathVariable Long id) {
        Optional<Pedido> pedidoOpt = pedidoService.findById(id);

        if (!pedidoOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Pedido pedido = pedidoOpt.get();

        PedidoDTO pedidoDTO = PedidoMapper.crearPedidoDTO(pedido);

        return new ResponseEntity<>(pedidoDTO, HttpStatus.OK);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido create(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }
}


//@RestController
//@RequestMapping("/clientes")
//public class ClienteController {
//
//    @Autowired
//    private IClienteService clienteService;
//
//    @GetMapping("")
//    public List<ClienteDTO> index() {
//        List<Cliente> temp=clienteService.findAll();
//        List<ClienteDTO> lista= new ArrayList<>();
//
//        for(int i = 0; i < temp.size(); i++){
//            ClienteDTO aux= ClienteMapper.crearDTO(temp.get(i));
//            lista.add(aux);
//        }
//
//        return lista;
//    }
//
//    @GetMapping("{id}")
//    public Cliente show (@PathVariable Long id){
//        return clienteService.findById(id).orElse(null);
//    }
//
//    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Cliente create (@RequestBody Cliente cliente){
//        return clienteService.save(cliente);
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id){
//        Cliente clienteActual= clienteService.findById(id).orElse(null);
//
//        clienteActual.setNombre(cliente.getNombre());
//        clienteActual.setApellido(cliente.getApellido());
//        clienteActual.setDni(cliente.getDni());
//
//        return clienteService.save(clienteActual);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete (@PathVariable Long id){
//        clienteService.delete(id);
//    }
//}