package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.repo.modelo.CitaMedica;

public interface ICitaMedicaService {

	//Agendamiento cita recibiendo distintos atributos
	public void agendar(String nTurno, LocalDate fechaCita, BigDecimal costoCita, String lugarCita, String cedulaDoctor, String cedulaPaciente);
	public CitaMedica buscarPorNumTurno(String nTurno);
	
	//Actualizando cita recibiendo distintos atributos
	public void actualizarPorNumTurno(String nTurno, String diagnostico, String receta, LocalDate fechaControl);
	
	public List<CitaMedica> reporte(LocalDate fecha, BigDecimal costo);
}
