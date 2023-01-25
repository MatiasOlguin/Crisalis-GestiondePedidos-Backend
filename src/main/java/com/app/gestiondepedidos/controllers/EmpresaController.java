package com.app.gestiondepedidos.controllers;

import com.app.gestiondepedidos.dto.ClienteDTO;
import com.app.gestiondepedidos.dto.EmpresaDTO;
import com.app.gestiondepedidos.dto.EmpresaMapper;
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


    @GetMapping("")
    public List<EmpresaDTO> index() {
        List<EmpresaDTO> lista= new ArrayList<>();
        List<Empresa> temp=empresaService.findAll();

        for(int i=0; i < temp.size(); i++){
            lista.add(EmpresaMapper.crearDTO(temp.get(i)));
        }

        return lista;
    }

    @GetMapping("{id}")
    public EmpresaDTO show(@PathVariable Long id) {
        return EmpresaMapper.crearDTO(empresaService.findById(id).orElse(null));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa create(@RequestBody EmpresaDTO empresaDTO) {
        Empresa empresa=new Empresa();

        empresa.setRazonSocial(empresaDTO.getRazonSocial());
        empresa.setCuit(empresaDTO.getCuit());
        empresa.setInicioActividades(empresaDTO.getInicioActividades());


        return empresaService.save(empresa);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Empresa> addEmpleado(@PathVariable Long id, @RequestBody ClienteDTO empleado) {
        Optional <Empresa> empresaOpt= empresaService.findById(id);

        if (!empresaOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Empresa empresa= empresaOpt.get();

        empresa.addEmpleados(empleadoService.findById(empleado.getId()).get());
        empresa=empresaService.save(empresa);

        return new ResponseEntity<>(empresa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa update(@RequestBody EmpresaDTO empresaDTO, @PathVariable Long id) {
        Empresa empresaActual = empresaService.findById(id).orElse(null);

        empresaActual.setRazonSocial(empresaDTO.getRazonSocial());
        empresaActual.setCuit(empresaDTO.getCuit());
        empresaActual.setInicioActividades(empresaDTO.getInicioActividades());

        return empresaService.save(empresaActual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id){
        empresaService.delete(id);
    }
}


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