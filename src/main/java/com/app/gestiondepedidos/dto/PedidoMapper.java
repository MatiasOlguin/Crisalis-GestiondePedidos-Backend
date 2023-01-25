package com.app.gestiondepedidos.dto;

import com.app.gestiondepedidos.enums.Estado;
import com.app.gestiondepedidos.models.Pedido;
import java.util.ArrayList;
import java.util.Objects;

public class PedidoMapper {

    public static PedidoDTO crearPedidoDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setEstado(pedido.getEstado().getEstado());
        pedidoDTO.setCreateAt(pedido.getCreateAt());
        pedidoDTO.setMontoTotal(pedido.getMontoTotal());
        pedidoDTO.setCliente(ClienteMapper.crearClienteNombreCompletoDTO(pedido.getCliente()));

        if (!Objects.isNull(pedido.getItems()))
            pedidoDTO.setItems( pedido.getItems());
        else
            pedidoDTO.setItems(new ArrayList<>());

        return pedidoDTO;
    }
}
