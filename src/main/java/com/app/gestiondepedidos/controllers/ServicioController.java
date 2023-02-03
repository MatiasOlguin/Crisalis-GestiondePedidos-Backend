package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.models.Servicio;
import com.app.gestiondepedidos.services.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicios")
public class ServicioController {
    @Autowired
    private IServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<Servicio>> index() {
        List<Servicio> servicios = servicioService.findAll();

        if (servicios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Servicio> show(@PathVariable Long id) {
        Optional<Servicio> servicioOpt = servicioService.findById(id);

        if (!servicioOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Servicio servicio = servicioOpt.get();

        return new ResponseEntity<>(servicio, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Servicio> create(@RequestBody Servicio servicio) {
        Servicio servicioCreado = servicioService.save(servicio);
        return new ResponseEntity<>(servicioCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> update(@RequestBody Servicio servicio, @PathVariable Long id) {
        Optional<Servicio> servicioOpt = servicioService.findById(id);

        if (!servicioOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Servicio servicioActual = servicioOpt.get();

        servicioActual.setDescripcion(servicio.getDescripcion());
        servicioActual.setMontoBase(servicio.getMontoBase());
        servicioActual.setTipo(servicio.getTipo());

        servicioService.save(servicioActual);

        return new ResponseEntity<>(servicioActual, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Servicio> servicioOpt = servicioService.findById(id);

        if (!servicioOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        servicioService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}