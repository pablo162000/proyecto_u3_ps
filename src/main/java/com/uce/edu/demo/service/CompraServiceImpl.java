package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class CompraServiceImpl implements ICompraService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Autowired
	private IClienteRepository iClienteRepository;
	@Autowired
	private IProductoRepository iProductoRepository;

	@Autowired
	private IFacturaElectronicaRepository iFacturaElectronicaRepository;

	List<DetalleFactura> listDetalleFacturas = new ArrayList<>();
	Factura factura = new Factura();

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void crearFacturaYDetalles(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {

		Cliente cliente = this.iClienteRepository.buscarPorCedula(cedulaCliente);
		factura.setCliente(cliente);
		factura.setNumero(numeroFactura);
		factura.setFecha(LocalDateTime.now());

		// List<DetalleFactura> listDetalleFacturas = new ArrayList<>();

		for (String codigo : codigoBarras) {
			Producto producto = this.iProductoRepository.buscarProducto(codigo);
			DetalleFactura detalleFactura = new DetalleFactura();
			detalleFactura.setCantidad(1);
			detalleFactura.setProducto(producto);
			detalleFactura.setFactura(factura);
			detalleFactura.setSubtotal(producto.getPrecio());
			listDetalleFacturas.add(detalleFactura);

			Integer stocknuevo = producto.getStock() - 1;
			producto.setStock(stocknuevo);
			this.iProductoRepository.actualizar(producto);

		}

		factura.setDetalles(listDetalleFacturas);

		iFacturaRepository.insertaFactura(factura);

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)

	public void registrarSRI() {
		// TODO Auto-generated method stub
		BigDecimal monto = new BigDecimal(0);
		FacturaElectronica facturaElectronica = new FacturaElectronica();
		facturaElectronica.setFechaCreacion(LocalDateTime.now());
		for (DetalleFactura detalle : listDetalleFacturas) {
			monto = monto.add(detalle.getSubtotal());

		}
		facturaElectronica.setMonto(monto);
		facturaElectronica.setNumero(factura.getNumero());
		facturaElectronica.setNumeroItems(listDetalleFacturas.size());
		// inserta factura electronica
		this.iFacturaElectronicaRepository.insertar(facturaElectronica);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)

	public void realizarVenta(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		this.crearFacturaYDetalles(cedulaCliente, numeroFactura, codigoBarras);
		this.registrarSRI();
	}

}
