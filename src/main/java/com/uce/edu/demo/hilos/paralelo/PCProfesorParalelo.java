package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

import com.uce.edu.demo.hilos.tradicional.Profesor;

public class PCProfesorParalelo extends Thread{
	
	private Profesor profesor;
	
	public PCProfesorParalelo(Profesor profesor) {
		this.profesor = profesor;

	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.procesar(profesor);
	}

	
	
	public void procesar(Profesor profesor) {
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo procesar : "+ Thread.currentThread().getName());
		System.out.println("Procesando proceso : " + profesor.getNombre());
		for (String alumno : profesor.getAlumnos()) {
			this.calificarAlumno(alumno);
		}
		
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println("termino: " + profesor.getNombre()+" en: "+tiempoTranscurrido + "seg");

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
