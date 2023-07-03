package com.example.demo.repo.modelo;

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
@Table(name = "paciente")
public class Paciente {

	@Id
	@SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", allocationSize = 1)
	@GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
	@Column(name = "paci_id")
	private Integer id;
	@Column(name = "paci_cedula")
	private String cedula;
	@Column(name = "paci_nombre")
	private String nombre;
	@Column(name = "paci_apellido")
	private String apellido;
	@Column(name = "paci_fecha_nacimiento")
	private LocalDate fechaNacimiento;
	@Column(name = "paci_codigo_iess")
	private String codIess;
	@Column(name = "paci_estatura")
	private String estatura;
	@Column(name = "paci_peso")
	private String peso;
	@Column(name = "paci_genero")
	private String genero;

	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
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
	public String getCodIess() {
		return codIess;
	}
	public void setCodIess(String codIess) {
		this.codIess = codIess;
	}
	public String getEstatura() {
		return estatura;
	}
	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getId() {
		return id;
	}
	public List<CitaMedica> getCitasMedicas() {
		return citasMedicas;
	}
	public void setCitasMedicas(List<CitaMedica> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}
	
	//toString
//	@Override
//	public String toString() {
//		return "Paciente [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
//				+ ", fechaNacimiento=" + fechaNacimiento + ", codIess=" + codIess + ", estatura=" + estatura + ", peso="
//				+ peso + ", genero=" + genero + ", citasMedicas=" + citasMedicas + "]";
//	}
	
		
}
