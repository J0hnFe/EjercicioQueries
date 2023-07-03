package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IPacienteRepo;
import com.example.demo.repo.modelo.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepo pacienteRepo;

	@Override
	public void agregar(Paciente p) {
		this.pacienteRepo.agregar(p);
	}

	@Override
	public void actualizar(Paciente doctor) {
		this.pacienteRepo.actualizar(doctor);
	}

	@Override
	public Paciente buscar(String cedula) {
		return this.pacienteRepo.seleccionar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		this.pacienteRepo.eliminar(cedula);
	}
	
}
