package com.app.gestiondepedidos.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpresaDTO {
    private Long id;
    private String razonSocial;
    private Date inicioActividades;
    private String cuit;
    private Date createAt;
    private List<ClienteNombreCompletoDTO> empleados;

    public EmpresaDTO (){
        empleados=new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getInicioActividades() {
        return inicioActividades;
    }

    public void setInicioActividades(Date inicioActividades) {
        this.inicioActividades = inicioActividades;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<ClienteNombreCompletoDTO> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<ClienteNombreCompletoDTO> empleados) {
        this.empleados = empleados;
    }
}
