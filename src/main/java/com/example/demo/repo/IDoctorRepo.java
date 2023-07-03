package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Doctor;

public interface IDoctorRepo {

	public void insertar(Doctor d);
	public void actualizar(Doctor d);
	public Doctor seleccionar(String cedula);
	public void eliminar(String cedula);
	
}
