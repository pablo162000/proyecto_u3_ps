package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.uce.edu.demo.repository.modelo.FacturaElectronica;

@Transactional
public interface IFacturaElectronicaRepository {
	
	public void insertar(FacturaElectronica facturaElectronica);
	
	

}
