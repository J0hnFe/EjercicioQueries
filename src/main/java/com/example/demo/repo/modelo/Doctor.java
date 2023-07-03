package com.example.demo.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@SequenceGenerator(name = "seq_doctor", sequenceName = "seq_doctor", allocationSize = 1)
	@GeneratedValue(generator = "seq_doctor", strategy = GenerationType.SEQUENCE)
	@Column(name = "doct_id")
	private Integer id;
	@Column(name = "doct_cedula")
	private String cedula;
	@Column(name = "doct_nombre")
	private String nombre;
	@Column(name = "doct_apellido")
	private String apellido;
	@Column(name = "doct_fecha_nacimiento")
	private LocalDate fechaNacimiento;
	@Column(name = "doct_numero_consultorio")
	private String nConsultorio;
	@Column(name = "doct_titulo")
	private String titulo;
	@Column(name = "doct_salario")
	private BigDecimal salario;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<CitaMedica> citasMedicas;
	
	//Getters y Setters
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getnConsultorio() {
		return nConsultorio;
	}

	public void setnConsultorio(String nConsultorio) {
		this.nConsultorio = nConsultorio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public List<CitaMedica> getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(List<CitaMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

	public Integer getId() {
		return id;
	}

	//toString
//	@Override
//	public String toString() {
//		return "Doctor \n[id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
//				+ ", fechaNacimiento=" + fechaNacimiento + ", nConsultorio=" + nConsultorio + ", titulo=" + titulo
//				+ ", salario=" + salario + ", citasMedicas=" + citasMedicas + "]";
//	}
	
}
