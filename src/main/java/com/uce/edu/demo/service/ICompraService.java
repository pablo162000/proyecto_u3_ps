package com.uce.edu.demo.service;

import java.util.List;


public interface ICompraService {
	
	
	public void realizarCompraDeProducto(String cedulaCliente, String numeroFactura, List<String> codigoBarras);
	
	
	

}
