package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.dto.EmpresaDTO;
import com.app.gestiondepedidos.dto.EmpresaMapper;
import com.app.gestiondepedidos.models.Cliente;
import com.app.gestiondepedidos.models.Empresa;
import com.app.gestiondepedidos.services.IClienteService;
import com.app.gestiondepedidos.services.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private IEmpresaService empresaService;

    @Autowired
    private IClienteService empleadoService;


    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> index() {
        List<Empresa> temp = empresaService.findAll();

        if (temp.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<EmpresaDTO> empresas = new ArrayList<>();

        for (int i = 0; i < temp.size(); i++) {
            EmpresaDTO aux = EmpresaMapper.crearEmpresaDTO(temp.get(i));
            empresas.add(aux);
        }

        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmpresaDTO> show(@PathVariable Long id) {
        Optional<Empresa> empresaOpt = empresaService.findById(id);

        if (!empresaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        EmpresaDTO empresa = EmpresaMapper.crearEmpresaDTO(empresaOpt.get());

        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa) {
        Empresa empresaCreada = empresaService.save(empresa);
        return new ResponseEntity<>(empresaCreada, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Empresa> addEmpleado(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Empresa> empresaOpt = empresaService.findById(id);
        Optional<Cliente> empleadoOpt = empleadoService.findById(cliente.getId());

        if (!empresaOpt.isPresent() || !empleadoOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Empresa empresa = empresaOpt.get();
        Cliente empleado = empleadoOpt.get();

        empresa.addEmpleados(empleado);

        return new ResponseEntity<>(empresa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@RequestBody Empresa empresa, @PathVariable Long id) {
        Optional<Empresa> empresaOpt = empresaService.findById(id);

        if (!empresaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Empresa empresaActual= empresaOpt.get();

        empresaActual.setRazonSocial(empresa.getRazonSocial());
        empresaActual.setCuit(empresa.getCuit());
        empresaActual.setInicioActividades(empresa.getInicioActividades());

        empresaService.save(empresaActual);

        return new ResponseEntity<>(empresaActual, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Empresa> empresaOpt = empresaService.findById(id);

        if (!empresaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        empresaService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}