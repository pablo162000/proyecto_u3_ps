package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());

		CajeroParalelo cajero1 = new CajeroParalelo("Edison", Arrays.asList("Pepito"));
		CajeroParalelo cajero2 = new CajeroParalelo("Luis", Arrays.asList("Pepito2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Paul", Arrays.asList("Pepito3"));
		CajeroParalelo cajero4 = new CajeroParalelo("Edison", Arrays.asList("Pepito"));
		CajeroParalelo cajero5 = new CajeroParalelo("Luis", Arrays.asList("Pepito2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Paul", Arrays.asList("Pepito3"));
		
		
		// Edison
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start();// procesar
		// Luis
		PCCajeroParalelo gestorAtencion1 = new PCCajeroParalelo(cajero2);
		gestorAtencion1.start();// procesar
		// Paul
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero3);
		gestorAtencion2.start();// procesar

		// Edison
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero4);
		gestorAtencion3.start();// procesar
		// Luis
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero5);
		gestorAtencion4.start();// procesar
		// Paul
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero6);
		gestorAtencion5.start();// procesar

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "seg");

	}

}
