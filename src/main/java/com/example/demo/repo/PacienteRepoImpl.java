package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void agregar(Paciente paciente) {
		this.entityManager.persist(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);
	}

	@Override
	public Paciente seleccionar(String cedula) {
		TypedQuery<Paciente> query = this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula = :datoCedula", Paciente.class);
		query.setParameter("datoCedula", cedula);
		return query.getSingleResult();
	}

	@Override
	public void eliminar(String cedula) {
		Paciente paciAux = this.seleccionar(cedula);
		this.entityManager.remove(paciAux);
	}

}
