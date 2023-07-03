package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Doctor d) {
		this.entityManager.persist(d);
	}

	@Override
	public void actualizar(Doctor d) {
		this.entityManager.merge(d);
	}

	@Override
	public Doctor seleccionar(String cedula) {
		TypedQuery<Doctor> query = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula = :datoCedula", Doctor.class);
		query.setParameter("datoCedula", cedula);
		return query.getSingleResult();
	}

	@Override
	public void eliminar(String cedula) {
		Doctor docAux = this.seleccionar(cedula);
		this.entityManager.remove(docAux);
	}

}
