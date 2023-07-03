package com.example.demo.repo;

import com.example.demo.repo.modelo.Paciente;

public interface IPacienteRepo {

	public void agregar(Paciente paciente);
	public void actualizar(Paciente paciente);
	public Paciente seleccionar(String cedula);
	public void eliminar(String cedula);
	
}
