package com.app.gestiondepedidos.dto;

import com.app.gestiondepedidos.models.Cliente;
import com.app.gestiondepedidos.models.Empresa;

import java.util.List;

public class EmpresaMapper {

    public static EmpresaDTO crearEmpresaDTO(Empresa empresa) {
        EmpresaDTO tempDTO = new EmpresaDTO();
        tempDTO.setId(empresa.getId());
        tempDTO.setRazonSocial(empresa.getRazonSocial());
        tempDTO.setCuit(empresa.getCuit());
        tempDTO.setInicioActividades(empresa.getInicioActividades());
        tempDTO.setCreateAt(empresa.getCreateAt());

        for (Cliente empleado : empresa.getEmpleados()) {
            ClienteNombreCompletoDTO cliente = new ClienteNombreCompletoDTO();
            cliente.setId(empleado.getId());
            cliente.setNombreCompleto(empleado.getNombre() + " " + empleado.getApellido());
            tempDTO.getEmpleados().add(cliente);
        }
        return tempDTO;
    }
}
