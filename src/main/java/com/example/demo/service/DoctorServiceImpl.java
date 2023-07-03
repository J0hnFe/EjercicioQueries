package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IDoctorRepo;
import com.example.demo.repo.modelo.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService{

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public void agregar(Doctor doctor) {
		this.doctorRepo.insertar(doctor);
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.doctorRepo.actualizar(doctor);
	}

	@Override
	public Doctor buscar(String cedula) {
		return this.doctorRepo.seleccionar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		this.doctorRepo.eliminar(cedula);
	}
	
	
}
