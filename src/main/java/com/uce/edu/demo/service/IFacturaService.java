package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaService {
	
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);
	public List<Factura> buscarFacturaInnerJoin();


	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad);
	public List<Factura> buscarFacturaOuterJoinLeft();
	
	
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);
	public List<Factura> buscarFacturaOuterJoinRight();

	
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad); 
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad);
	
	
	public BigDecimal procesarFactura(String cedulaCliente, String numeroFactura, List<String> codigoBarras);

}
