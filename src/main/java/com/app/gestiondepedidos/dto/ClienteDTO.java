package com.app.gestiondepedidos.dto;

import com.app.gestiondepedidos.models.Empresa;
import com.app.gestiondepedidos.models.ServicioActivo;

import java.util.Date;
import java.util.List;

public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date createAt;

    private EmpresaRazonSocialDTO empresa;

    private List<ServicioActivo> servicios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public EmpresaRazonSocialDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaRazonSocialDTO empresa) {
        this.empresa = empresa;
    }

    public List<ServicioActivo> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioActivo> servicios) {
        this.servicios = servicios;
    }
}
