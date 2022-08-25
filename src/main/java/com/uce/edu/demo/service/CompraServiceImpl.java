package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements ICompraService {

	

	@Autowired
	private IFacturaService iFacturaService;
	
	@Autowired
	private IFacturaElectronicaService iFacturaElectronicaService;

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void realizarCompra(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		
		BigDecimal totalPagar = this.iFacturaService.procesarFactura(cedulaCliente, numeroFactura, codigoBarras);
		
		this.iFacturaElectronicaService.procesarElectronica(numeroFactura, codigoBarras.size(), totalPagar);
	}

	



	

}
