package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.modelo.CitaMedica;
import com.example.demo.repo.modelo.Doctor;
import com.example.demo.repo.modelo.Paciente;
import com.example.demo.service.ICitaMedicaService;
import com.example.demo.service.IDoctorService;
import com.example.demo.service.IPacienteService;

@SpringBootApplication
public class EjercicioQueriesApplication implements CommandLineRunner{

	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private IPacienteService pacienteService;
	@Autowired
	private ICitaMedicaService citaMedicaService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioQueriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LocalDate fechaNacimientoDoc1 = LocalDate.of(2000, 1, 9);
		LocalDate fechaNacimientoDoc2 = LocalDate.of(1998, 1, 9);
		LocalDate fechaNacimientoPaci1 = LocalDate.of(2005, 1, 9);
		LocalDate fechaNacimientoPaci2 = LocalDate.of(1980, 1, 9);
		
		//Agregar 2 doctores
		Doctor doct1 = new Doctor();
		doct1.setCedula("001");
		doct1.setNombre("Felipe");
		doct1.setApellido("Ramos");
		doct1.setFechaNacimiento(fechaNacimientoDoc1);
		doct1.setnConsultorio("10");
		doct1.setTitulo("Neurologo");
		doct1.setSalario(new BigDecimal(2500));

		Doctor doct2 = new Doctor();
		doct2.setCedula("002");
		doct2.setNombre("Oscar");
		doct2.setApellido("Tamal");
		doct2.setFechaNacimiento(fechaNacimientoDoc2);
		doct2.setnConsultorio("11");
		doct2.setTitulo("Otorrino");
		doct2.setSalario(new BigDecimal(1500));		

		//Agregar 2 Pacientes
		Paciente paci1 = new Paciente();
		paci1.setCedula("003");
		paci1.setNombre("Rebeca");
		paci1.setApellido("Flores");
		paci1.setFechaNacimiento(fechaNacimientoPaci1);
		paci1.setCodIess("246");
		paci1.setEstatura("1.70");
		paci1.setPeso("79 kg");
		paci1.setGenero("F");
		

		Paciente paci2 = new Paciente();
		paci2.setCedula("004");
		paci2.setNombre("Nicolas");
		paci2.setApellido("Mora");
		paci2.setFechaNacimiento(fechaNacimientoPaci2);
		paci2.setCodIess("135");
		paci2.setEstatura("1.80");
		paci2.setPeso("66 kg");
		paci2.setGenero("M");

//		this.doctorService.agregar(doct1);
//		this.doctorService.agregar(doct2);
//		
//		this.pacienteService.agregar(paci1);
//		this.pacienteService.agregar(paci2);

		String nTurno = "158";
		LocalDate fechaCita = LocalDate.of(2023, 7, 25);
		BigDecimal costoCita = new BigDecimal(20);
		String lugarCita = "Monteserrin";
		
//		this.citaMedicaService.agendar(nTurno, fechaCita, costoCita, lugarCita, doct1.getCedula(), paci2.getCedula());
		
		String diagnostico = "Le queda poco tiempo...";
		String receta = "Buprex";
		LocalDate fechaControl = LocalDate.of(2023, 8, 10);
		
//		this.citaMedicaService.actualizarPorNumTurno(nTurno, diagnostico, receta, fechaControl);

		//Otras citas medicas
		LocalDate fechaCita2 = LocalDate.of(2023, 6, 25);
		String nTurno2 = "258";
		BigDecimal costoCita2 = new BigDecimal(10);
		String lugarCita2 = "Amaguania";
		
		LocalDate fechaCita3 = LocalDate.of(2020, 6, 25);
		String nTurno3 = "358";
		BigDecimal costoCita3 = new BigDecimal(50);
		String lugarCita3 = "Calderon";
		
//		this.citaMedicaService.agendar(nTurno2, fechaCita2, costoCita2, lugarCita2, doct2.getCedula(), paci1.getCedula());
//		this.citaMedicaService.agendar(nTurno3, fechaCita3, costoCita3, lugarCita3, doct1.getCedula(), paci1.getCedula());

		LocalDate fechaAux = LocalDate.now();
		BigDecimal costoAux = new BigDecimal(5);
		
		List<CitaMedica> citasMedicas = this.citaMedicaService.reporte(fechaAux, costoAux);
		citasMedicas.stream().forEach(System.out::println);
//		System.out.println(citasMedicas.toString());h
		
	}

}
