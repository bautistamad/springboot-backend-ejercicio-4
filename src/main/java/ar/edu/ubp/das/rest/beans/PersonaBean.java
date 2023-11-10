package ar.edu.ubp.das.rest.beans;

import java.util.Date;

public class PersonaBean {

	private int nroPersona;
	private String nombre;
	private String apellido;
	private String clave;
	private String correo;
	private String nomGenero;
	private Date fechaNacimiento;
	private String nomNacionalidad;

	public int getNroPersona() {
		return nroPersona;
	}

	public void setNroPersona(int nroPersona) {
		this.nroPersona = nroPersona;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNomGenero() {
		return nomGenero;
	}

	public void setNomGenero(String nomGenero) {
		this.nomGenero = nomGenero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNomNacionalidad() {
		return nomNacionalidad;
	}

	public void setNomNacionalidad(String nomNacionalidad) {
		this.nomNacionalidad = nomNacionalidad;
	}
}
