package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.dto.PedidoDTO;
import com.app.gestiondepedidos.dto.PedidoMapper;
import com.app.gestiondepedidos.enums.Estado;
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
    public ResponseEntity<List<PedidoDTO>> index() {
        List<Pedido> temp=pedidoService.findAll();

        if (temp.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<PedidoDTO> pedidos= new ArrayList<>();

        for(int i = 0; i < temp.size(); i++){
            PedidoDTO aux= PedidoMapper.crearPedidoDTO(temp.get(i));
            pedidos.add(aux);
        }
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
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

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
        Pedido pedidoCreado= pedidoService.save(pedido);
        return new ResponseEntity<>(pedidoCreado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Pedido> pedidoOpt = pedidoService.findById(id);

        if (!pedidoOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        pedidoService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/{estado}")
    public ResponseEntity<Void> actualizarEstado(@PathVariable Long id,@PathVariable String estado){
        pedidoService.actualizarEstado(id, estado);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}