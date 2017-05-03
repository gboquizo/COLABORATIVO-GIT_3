package miPersona;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * @author Javier Ponferrada López
 * @version 1.0
 * 
 */
public class Persona implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	
	public Persona(String nombre, String apellidos,LocalDate fechaNacimiento) {
		setNombre(nombre);
		setApellidos(apellidos);
		setFechaNacimiento(fechaNacimiento);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	private void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	private void setFechaNacimiento(LocalDate fechaNacimiento2) {
		this.fechaNacimiento = fechaNacimiento2;
	}
	/**
	 * Calcular fecha de nacimento
	 * */
	long calcularEdad(){
		return ChronoUnit.YEARS.between(getFechaNacimiento(), LocalDate.now());
		 
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + calcularEdad() + "]";
	}
}
