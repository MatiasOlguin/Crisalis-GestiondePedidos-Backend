package com.app.gestiondepedidos.services;

import com.app.gestiondepedidos.models.*;
import com.app.gestiondepedidos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements IPedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private IProductoService productoService;
    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private CalculosService calculosService;


    @Override
    @Transactional(readOnly = true)
    public List<Pedido> findAll() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    @Transactional
    public Pedido save(Pedido pedido) {
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId()).get();
        Pedido nuevoPedido = new Pedido();

        nuevoPedido.setCliente(cliente);


        for (int i = 0; i < pedido.getItems().size(); i++) {
            Item nuevoItem = new Item();
            if (!pedido.getItems().get(i).productoEsVacio()) {
                Producto producto = productoService.findById(pedido.getItems().get(i).getProducto().getId()).get();

                productoService.actualizarCantidad(producto.getId(), producto.getCantidad() - pedido.getItems().get(i).getCantidad());

                nuevoItem.setProducto(producto);
                nuevoItem.setCantidad(pedido.getItems().get(i).getCantidad());
                nuevoItem.setSubtotal(pedido.getItems().get(i).getProducto().getMontoBase() * pedido.getItems().get(i).getCantidad());

                if (pedido.getItems().get(i).getAniosGarantia() != null) {
                    nuevoItem.setAniosGarantia(pedido.getItems().get(i).getAniosGarantia());
                    nuevoItem.setAdicional(nuevoItem.getSubtotal() * 0.02 * nuevoItem.getAniosGarantia());
                    nuevoItem.setSubtotal((nuevoItem.getSubtotal() + nuevoItem.getAdicional()));
                }

                nuevoItem.setIVA(calculosService.calcularImpuesto(0.21, nuevoItem.getSubtotal()));
                nuevoItem.setIIBB(calculosService.calcularImpuesto(0.035, nuevoItem.getSubtotal()));

                nuevoItem.setTotal((nuevoItem.getSubtotal() + nuevoItem.getIVA() + nuevoItem.getIIBB()));

                itemRepository.save(nuevoItem);
                nuevoPedido.addItem(nuevoItem);

            } else {
                Servicio servicio = servicioRepository.findById(pedido.getItems().get(i).getServicio().getId()).get();

                nuevoItem.setServicio(servicio);
                nuevoItem.setCantidad(1);
                nuevoItem.setSubtotal(pedido.getItems().get(i).getServicio().getMontoBase());

                nuevoItem.setIVA(calculosService.calcularImpuesto(0.21, nuevoItem.getSubtotal()));
                nuevoItem.setIIBB(calculosService.calcularImpuesto(0.035, nuevoItem.getSubtotal()));

                if (pedido.getItems().get(i).getAdicional() != null) {
                    nuevoItem.setAdicional(pedido.getItems().get(i).getAdicional());
                    nuevoItem.setTotal(nuevoItem.getSubtotal() + nuevoItem.getIVA() + nuevoItem.getIIBB() + nuevoItem.getAdicional());
                } else
                    nuevoItem.setTotal(nuevoItem.getSubtotal() + nuevoItem.getIVA() + nuevoItem.getIIBB());

                itemRepository.save(nuevoItem);
                nuevoPedido.addItem(nuevoItem);
            }
        }

        nuevoPedido.setTotal(calculosService.calcularMontoTotal(nuevoPedido));

        return pedidoRepository.save(nuevoPedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Pedido pedido = pedidoRepository.findById(id).get();

        for (int i = 0; i < pedido.getItems().size(); i++) {

            if (!pedido.getItems().get(i).productoEsVacio()) {
                Producto producto = productoService.findById(pedido.getItems().get(i).getProducto().getId()).get();
                producto.setCantidad(producto.getCantidad() + pedido.getItems().get(i).getCantidad());
                productoService.save(producto);
            }
        }

        pedidoRepository.deleteById(id);
    }
}