package com.uce.edu.demo.hilos.tradicional;

import java.util.List;

public class Profesor {

	private String nombre;
	private List<String> alumnos;

	public Profesor(String nombre, List<String> alumnos) {
		super();
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<String> alumnos) {
		this.alumnos = alumnos;
	}

}
