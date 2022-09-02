package com.uce.edu.demo.service.funcional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	

	public static void guardar() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		// SUPPLIER

		// JAVA
		LOG.info("JAVA supplier");

		Stream<Double> numeroaletorios = Stream.generate(() -> Math.random()).limit(5);
		numeroaletorios.forEach(numero -> System.out.println(numero));

		// CONSUMER

		// JAVA
		LOG.info("JAVA consumer");

		List<Double> listaNumeros1 = new ArrayList<Double>();
		listaNumeros1.add(Math.random());
		listaNumeros1.add(Math.random());
		listaNumeros1.add(Math.random());
		listaNumeros1.add(Math.random());
		listaNumeros1.add(Math.random());
		listaNumeros1.add(Math.random());

		listaNumeros1.stream().forEach(n -> System.out.println(n));

		// PREDICATE
		
		// JAVA
		LOG.info("JAVA Predicate");

		listaNumeros1.stream().filter(n-> n>=0).forEach(n -> System.out.println(n));
		// FUNCTION
		// JAVA
		LOG.info("JAVA Function");
		// Conversiones/cast
		
		listaNumeros1.stream().map(n-> new BigDecimal(n).setScale(4, RoundingMode.HALF_UP)).forEach(n -> System.out.println(n));
		

	
	}

}
