package com.app.gestiondepedidos.services;


import com.app.gestiondepedidos.models.Pedido;
import org.springframework.stereotype.Service;

@Service
public class CalculosService {
    public Double calcularMontoTotal(Pedido pedido) {
        Double total = 0.0;

        for (int i = 0; i < pedido.getItems().size(); i++) {
            total+= pedido.getItems().get(i).getTotal();
        }

        return total;
    }

    public Double calcularImpuesto(Double porcentaje, Double monto) {
        Double temp;
        Double roundDbl;
        temp = monto * porcentaje;
        roundDbl = Math.round(temp * 100.0) / 100.0;
        return roundDbl;
    }
}