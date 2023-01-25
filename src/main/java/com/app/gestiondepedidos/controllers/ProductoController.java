package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.models.Producto;
import com.app.gestiondepedidos.services.IOfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IOfertaService ofertaService;

    @GetMapping("")
    public List<Producto> index() {
        return ofertaService.findAllProductos();
    }

    @GetMapping("{id}")
    public Producto show (@PathVariable Long id){
        return ofertaService.findByIdProducto(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto create (@RequestBody Producto producto){
        return (Producto) ofertaService.save(producto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto update(@RequestBody Producto producto, @PathVariable Long id){
        Producto productoActual= ofertaService.findByIdProducto(id);

        productoActual.setDescripcion(producto.getDescripcion());
        productoActual.setMontoBase(producto.getMontoBase());
        productoActual.setMarca(producto.getMarca());
        productoActual.setModelo(producto.getModelo());
        productoActual.setCantidad(producto.getCantidad());

        return (Producto) ofertaService.save(productoActual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id){
        ofertaService.delete(id);
    }
}