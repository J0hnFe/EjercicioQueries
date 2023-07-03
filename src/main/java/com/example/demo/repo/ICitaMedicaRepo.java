package com.example.demo.repo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.repo.modelo.CitaMedica;

public interface ICitaMedicaRepo {

	public void agregar(CitaMedica citaMedica);
	public CitaMedica seleccionarPorNumTurno(String n);
	public void actualizar(CitaMedica cm);
	
	//Reporte de citas medicas mayores a una fecha y costo determinado
	public List<CitaMedica> reporte(LocalDate fecha, BigDecimal costo);
	
}
