package com.uce.edu.demo.service;

import java.util.List;


public interface ICompraService {
	
	
	public void crearFacturaYDetalles(String cedulaCliente, String numeroFactura, List<String> codigoBarras);
	public void registrarSRI();

	public void realizarVenta(String cedulaCliente, String numeroFactura, List<String> codigoBarras);

	

}
