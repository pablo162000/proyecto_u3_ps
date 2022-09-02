package com.uce.edu.demo.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCProfesor {
	
	
	public void procesar(Profesor profesor) {
		System.out.println("Nombre Hilo procesar : "+ Thread.currentThread().getName());
		System.out.println("Procesando proceso : " + profesor.getNombre());
		for (String alumno : profesor.getAlumnos()) {
			this.calificarAlumno(alumno);
		}

	}
	
	public void calificarAlumno(String alumno) {
		System.out.println("Calificando a: "+ alumno);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
