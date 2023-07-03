package com.example.demo.service;

import java.math.BigDecimal;
import java.security.cert.LDAPCertStoreParameters;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ICitaMedicaRepo;
import com.example.demo.repo.IDoctorRepo;
import com.example.demo.repo.IPacienteRepo;
import com.example.demo.repo.modelo.CitaMedica;
import com.example.demo.repo.modelo.Doctor;
import com.example.demo.repo.modelo.Paciente;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{

	@Autowired
	private ICitaMedicaRepo citaMedicaRepo;
	
	@Autowired
	private IPacienteRepo pacienteRepo;
	
	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public void agendar(String nTurno, LocalDate fechaCita, BigDecimal costoCita, String lugarCita, String cedulaDoctor, String cedulaPaciente) {
		
		Doctor doctor = this.doctorRepo.seleccionar(cedulaDoctor);
		Paciente paciente = this.pacienteRepo.seleccionar(cedulaPaciente);
		
		CitaMedica citaMedica = new CitaMedica();
		citaMedica.setCostoCita(costoCita);
		citaMedica.setDoctor(doctor);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setLugar(lugarCita);
		citaMedica.setnTurno(nTurno);
		citaMedica.setPaciente(paciente);
		
		this.citaMedicaRepo.agregar(citaMedica);
	}

	@Override
	public CitaMedica buscarPorNumTurno(String nTurno) {
		return this.citaMedicaRepo.seleccionarPorNumTurno(nTurno);
	}

	@Override
	public void actualizarPorNumTurno(String nTurno, String diagnostico, String receta, LocalDate fechaControl) {
		
		CitaMedica citaMedica = this.citaMedicaRepo.seleccionarPorNumTurno(nTurno);
		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setReceta(receta);
		citaMedica.setFechaControl(fechaControl);
		
		this.citaMedicaRepo.actualizar(citaMedica);
		
	}

	@Override
	public List<CitaMedica> reporte(LocalDate fecha, BigDecimal costo) {
		return this.citaMedicaRepo.reporte(fecha, costo);
	}

}
