package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class MainProfesor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());

		Profesor profesor1 = new Profesor("Ramiro", Arrays.asList("Xavier", "Mike"));
		Profesor profesor2 = new Profesor("Sandra", Arrays.asList("Xavier", "Mike"));
		Profesor profesor3 = new Profesor("Yuri", Arrays.asList("Xavier", "Mike"));
		
		
		PCProfesor gestorAtencion1 = new PCProfesor();
		
		gestorAtencion1.procesar(profesor1);

		PCProfesor gestorAtencion2 = new PCProfesor();
		gestorAtencion2.procesar(profesor2);


		PCProfesor gestorAtencion3 = new PCProfesor();
		gestorAtencion3.procesar(profesor3);
		
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "seg");

	}

}
