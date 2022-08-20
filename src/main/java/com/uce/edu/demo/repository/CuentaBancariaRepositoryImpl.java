package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU3PsApplication;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	
	private static Logger LOG = Logger.getLogger(CuentaBancariaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		
		this.entityManager.merge(cuentaBancaria);
		//throw new RuntimeException();

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)

	public CuentaBancaria buscarPorNumero(String numeroCta) {
		// TODO Auto-generated method stub
			LOG.info("Transacción activa: " + org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());		

		TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero =:numeroCta", CuentaBancaria.class);
		
		myQuery.setParameter("numeroCta", numeroCta);
		return myQuery.getSingleResult();
	}

}
