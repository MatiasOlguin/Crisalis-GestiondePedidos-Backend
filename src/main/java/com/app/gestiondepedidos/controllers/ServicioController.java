package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.models.Servicio;
import com.app.gestiondepedidos.services.IOfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/servicios")

public class ServicioController {
    @Autowired
    private IOfertaService ofertaService;

    @GetMapping("")
    public List<Servicio> index() {
        return ofertaService.findAllServicios();
    }

    @GetMapping("{id}")
    public Servicio show (@PathVariable Long id){
        return ofertaService.findByIdServicio(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio create (@RequestBody Servicio servicio){
        return (Servicio) ofertaService.save(servicio);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Servicio update(@RequestBody Servicio servicio, @PathVariable Long id){
        Servicio servicioActual= ofertaService.findByIdServicio(id);

        servicioActual.setDescripcion(servicio.getDescripcion());
        servicioActual.setMontoBase(servicio.getMontoBase());
        servicioActual.setCargoSoporte(servicio.getCargoSoporte());
        servicioActual.setTipo(servicio.getTipo());

        return (Servicio) ofertaService.save(servicioActual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id){
        ofertaService.delete(id);
    }
}