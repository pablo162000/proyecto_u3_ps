package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	private static Logger LOG = Logger.getLogger(HotelRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQuery.setParameter("tipo", tipoHabitacion);
		List<Hotel> hoteles = myQuery.getResultList();
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}

		return myQuery.getResultList();
	}

	public List<Hotel> buscarHotelInnerJoin2(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQuery.setParameter("tipo", tipoHabitacion);
		List<Hotel> hoteles = myQuery.getResultList();
		for (Hotel h : hoteles) {
			h.getHabitaciones().size();
		}

		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQuery.setParameter("tipo", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",
				Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQuery.setParameter("tipo", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// SELECT *FROM public.hotel ho, habitacion ha WHERE ho.hote_id =
		// ha.habi_id_hotel and ha.habi_tipo = 'Individual' ;

		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel AND ha.tipo =:tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		
		LOG.info("Transacción activa: " + org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive());		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha WHERE ha.tipo = :tipoHabitacion", Hotel.class);
		myQuery.setParameter("tipoHabitacion", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight() {
		// TODO Auto-generated method stub
		return null;
	}
}
