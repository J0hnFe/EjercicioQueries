package com.example.demo.repo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.CitaMedica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void agregar(CitaMedica citaMedica) {
		this.entityManager.persist(citaMedica);
	}

	@Override
	public CitaMedica seleccionarPorNumTurno(String n) {
		TypedQuery<CitaMedica> query = this.entityManager
				.createQuery("SELECT cm FROM CitaMedica cm WHERE cm.nTurno = :datoNTurno", CitaMedica.class);
		query.setParameter("datoNTurno", n);
		return query.getSingleResult();
	}

	@Override
	public void actualizar(CitaMedica cm) {
		this.entityManager.merge(cm);
	}

	@Override
	public List<CitaMedica> reporte(LocalDate fecha, BigDecimal costo) {
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery(
				"SELECT cm FROM CitaMedica cm WHERE cm.fechaCita > :datoFecha AND cm.costoCita > :datoCosto", CitaMedica.class);
		myQuery.setParameter("datoFecha", fecha);
		myQuery.setParameter("datoCosto", costo);
		return myQuery.getResultList();
	}

}
