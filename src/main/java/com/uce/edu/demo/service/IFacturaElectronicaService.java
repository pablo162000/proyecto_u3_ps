package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {
	
	public void procesarElectronica(String numeroFactura, Integer canitdadItems, BigDecimal monto);

}
