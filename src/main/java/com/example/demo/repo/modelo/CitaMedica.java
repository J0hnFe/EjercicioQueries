package com.example.demo.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cita_medica")
public class CitaMedica {
	
	@Id
	@SequenceGenerator(name = "seq_cita_medica", sequenceName = "seq_cita_medica", allocationSize = 1)
	@GeneratedValue(generator = "seq_cita_medica", strategy = GenerationType.SEQUENCE)
	@Column(name = "cime_id")
	private Integer id;
	@Column(name = "cime_numero_turno")
	private String nTurno;
	@Column(name = "cime_fecha_cita")
	private LocalDate fechaCita;
	@Column(name = "cime_costo_cita")
	private BigDecimal costoCita;
	@Column(name = "cime_lugar_cita")
	private String lugar;
	@Column(name = "cime_diagnostico")
	private String diagnostico;
	@Column(name = "cime_receta")
	private String receta;
	@Column(name = "cime_fecha_control")
	private LocalDate fechaControl;
	
	@ManyToOne
	@JoinColumn(name = "cime_id_doctor")
	private Doctor doctor;
	@ManyToOne
	@JoinColumn(name = "cime_id_paciente")
	private Paciente paciente;
	
	//Getters y Setters
	public String getnTurno() {
		return nTurno;
	}
	public void setnTurno(String nTurno) {
		this.nTurno = nTurno;
	}
	public LocalDate getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
	}
	public BigDecimal getCostoCita() {
		return costoCita;
	}
	public void setCostoCita(BigDecimal costoCita) {
		this.costoCita = costoCita;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getReceta() {
		return receta;
	}
	public void setReceta(String receta) {
		this.receta = receta;
	}
	public LocalDate getFechaControl() {
		return fechaControl;
	}
	public void setFechaControl(LocalDate fechaControl) {
		this.fechaControl = fechaControl;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Integer getId() {
		return id;
	}
	
	//toString
	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", nTurno=" + nTurno + ", fechaCita=" + fechaCita + ", costoCita=" + costoCita
				+ ", lugar=" + lugar + ", diagnostico=" + diagnostico + ", receta=" + receta + ", fechaControl="
				+ fechaControl + ", doctor=" + doctor + ", paciente=" + paciente + "]";
	}
	
	

}
