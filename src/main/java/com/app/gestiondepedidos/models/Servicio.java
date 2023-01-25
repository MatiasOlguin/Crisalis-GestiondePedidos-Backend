package com.app.gestiondepedidos.models;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value="servicio")
public class Servicio extends Oferta implements Serializable {
    @Column(name="cargo_soporte")
    private Double cargoSoporte;
    @Column(name="tipo_servicio")
    private String tipo;

    public Double getCargoSoporte() {
        return cargoSoporte;
    }
    public void setCargoSoporte(Double cargoSoporte) {
        this.cargoSoporte = cargoSoporte;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
