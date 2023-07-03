package com.example.demo.service;

import com.example.demo.repo.modelo.Paciente;

public interface IPacienteService {

	public void agregar(Paciente p);
	public void actualizar(Paciente doctor);
	public Paciente buscar(String cedula);
	public void borrar(String cedula);
	
}
