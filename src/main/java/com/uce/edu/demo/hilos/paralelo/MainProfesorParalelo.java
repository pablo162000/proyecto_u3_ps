package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

import com.uce.edu.demo.hilos.tradicional.Profesor;

public class MainProfesorParalelo {
	
	
	public static void main(String[] args) {
		
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		
		Profesor profesor1 = new Profesor("Ramiro", Arrays.asList("Xavier", "Mike"));
		Profesor profesor2 = new Profesor("Sandra", Arrays.asList("Xavier", "Mike"));
		Profesor profesor3 = new Profesor("Yuri", Arrays.asList("Xavier", "Mike"));
		Profesor profesor4 = new Profesor("David", Arrays.asList("Xavier", "Mike"));
		Profesor profesor5 = new Profesor("Wagner", Arrays.asList("Xavier", "Mike"));

		
		PCProfesorParalelo gestorAtencion1 = new PCProfesorParalelo(profesor1);
		gestorAtencion1.start();
		
		PCProfesorParalelo gestorAtencion2 = new PCProfesorParalelo(profesor2);
		gestorAtencion2.start();
		
		PCProfesorParalelo gestorAtencion3 = new PCProfesorParalelo(profesor3);
		gestorAtencion3.start();
		
		PCProfesorParalelo gestorAtencion4 = new PCProfesorParalelo(profesor4);
		gestorAtencion4.start();
		
		PCProfesorParalelo gestorAtencion5 = new PCProfesorParalelo(profesor5);
		gestorAtencion5.start();
		
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "seg");
		
	}
	
	
	
	
	

}
