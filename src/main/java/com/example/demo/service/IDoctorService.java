package com.example.demo.service;

import com.example.demo.repo.modelo.Doctor;

public interface IDoctorService {

	public void agregar(Doctor doctor);
	public void actualizar(Doctor doctor);
	public Doctor buscar(String cedula);
	public void borrar(String cedula);
	
}
