package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {

	@Autowired
	private IFacturaElectronicaRepository electronicaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarElectronica(String numeroFactura, Integer canitdadItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica electronica = new FacturaElectronica();
		
		electronica.setFechaCreacion(LocalDateTime.now());
		electronica.setMonto(monto);
		electronica.setNumero(numeroFactura);
		electronica.setNumeroItems(canitdadItems);
		
		this.electronicaRepository.insertar(electronica);
		
		throw new RuntimeException();
		
	}

}
