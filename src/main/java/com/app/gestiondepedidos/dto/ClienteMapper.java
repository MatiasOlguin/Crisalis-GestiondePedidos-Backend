package com.app.gestiondepedidos.dto;


import com.app.gestiondepedidos.models.Cliente;

import java.util.Objects;

public class ClienteMapper {

    public static ClienteDTO crearClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setDni(cliente.getDni());
        clienteDTO.setCreateAt(cliente.getCreateAt());

        if (!Objects.isNull(cliente.getEmpresa())) {
            EmpresaRazonSocialDTO aux=new EmpresaRazonSocialDTO();
            aux.setId(cliente.getEmpresa().getId());
            aux.setRazonSocial(cliente.getEmpresa().getRazonSocial());

            clienteDTO.setEmpresa(aux);
        }
        return clienteDTO;
    }

    public static ClienteNombreCompletoDTO crearClienteNombreCompletoDTO(Cliente cliente) {
        ClienteNombreCompletoDTO clienteDTO = new ClienteNombreCompletoDTO();

        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombreCompleto(cliente.getNombre() + ' '+ cliente.getApellido());

        return clienteDTO;
    }
}
