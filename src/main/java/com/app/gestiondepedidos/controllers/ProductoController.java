package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.models.Producto;
import com.app.gestiondepedidos.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> index() {
        List<Producto> productos = productoService.findAll();

        if (productos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Producto> show(@PathVariable Long id) {
        Optional<Producto> productoOpt = productoService.findById(id);

        if (!productoOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Producto producto = productoOpt.get();

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        Producto productoCreado = productoService.save(producto);
        return new ResponseEntity<>(productoCreado, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@RequestBody Producto producto, @PathVariable Long id) {
        Optional<Producto> productoOpt = productoService.findById(id);

        if (!productoOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Producto productoActual = productoOpt.get();

        productoActual.setDescripcion(producto.getDescripcion());
        productoActual.setMontoBase(producto.getMontoBase());
        productoActual.setMarca(producto.getMarca());
        productoActual.setModelo(producto.getModelo());
        productoActual.setCantidad(producto.getCantidad());

        productoService.save(productoActual);

        return new ResponseEntity<>(productoActual, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Producto> productoOpt = productoService.findById(id);

        if (!productoOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        productoService.borradoLogico(productoOpt.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        Optional<Producto> productoOpt = productoService.findById(id);
//
//        if (!productoOpt.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        productoService.delete(id);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}