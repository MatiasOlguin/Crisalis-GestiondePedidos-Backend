package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.Cliente;
import com.app.gestiondepedidos.models.Servicio;
import com.app.gestiondepedidos.models.ServicioActivo;
import com.app.gestiondepedidos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private IServicioActivoService servicioActivoService;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteRepository.findByBorradoFalse();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void borradoLogico(Cliente cliente){
        cliente.setBorrado(true);
        clienteRepository.save(cliente);
    }

    @Override
    public void activarServicio(Long id, Servicio servicio) {
        Cliente cliente = clienteRepository.findById(id).get();

        boolean flag=false;
        for(int i=0; i < cliente.getServicios().size() ; i++){
            if(cliente.getServicios().get(i).getServicio().getId() == servicio.getId()){
                flag=true;
                break;
            }
        }

        if(!flag){
            ServicioActivo servicioAct=new ServicioActivo();
            servicioAct.setServicio(servicio);
            servicioActivoService.save(servicioAct);
            cliente.addServicio(servicioAct);
            clienteRepository.save(cliente);
        }
    }
}