package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static boolean prueba(Integer numero) {
		return numero >= 3;
	}

	public static void imprimir(String cadena) {
		LOG.info("Impresion: "+ cadena);

	}
	
	public static void guardar() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		// SUPPLIER

		// Clases

		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());

		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase: " + supplierTE.getNombre());

		// Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Edison2";
		LOG.info("Supplier Lambdas: " + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE2";
		LOG.info("Supplier Lambdas: " + supplierLambdaTE.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola Mundo");
		LOG.info("HO Supplier " + valorHO);

		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "1725685";
			return valorConsultado;
		});
		LOG.info("HO Supplier " + valorHO1);
		// JAVA
		// Supplier
		LOG.info("JAVA Supplier");
		Stream<String> test = Stream.generate(() -> "Pablo 3").limit(7);
		test.forEach(cadena -> System.out.println(cadena));

		// CONSUMER
		// Clases

		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		// Lambdas

		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		// Metodos High Order

		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		// JAVA
		LOG.info("JAVA consumer");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);

		listaNumeros.forEach(numero -> System.out.println(numero));
		// listaNumeros.str
		// PREDICATE
		// Clases
		// Lambdas

		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Predicate Lambdas:" + predicateLambda.evaluar("Edison"));

		// Metodos High ORDER

		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("Z"), "EdiZon");
		LOG.info("HO Predicate " + respuesta);

		// JAVA
		LOG.info("JAVA Predicate");

		Stream<Integer> nuevalista = listaNumeros.stream().filter(numero ->prueba(numero));
		nuevalista.forEach(numero -> System.out.println(numero));
		// FUNCTION
		// Clases
		// Lambdas

		IPersonaFunction<Integer, String> funtionLambda = cadena -> {

			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;

			return valorFinal;
		};
		LOG.info("Function Lambdas:" + funtionLambda.aplicar("7"));

		// Metodos High Order

		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorn = valor.toString() + "A";
			return retorn;
		}, 1);
		LOG.info("HO Function: " + valorFinalHO);

		// JAVA
		LOG.info("JAVA Function");
		// Conversiones/cast

		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista + 1;
			String cadena = "num: " + valor.toString();
			return cadena;
		});
		//Declarativa
		listaCambiada.forEach(valor -> imprimir(valor));
		
//		List<String> lista1 =  new ArrayList<>();
//		Map<String, String> map1 = new HashMap<String, String>();
		
		//Stream: implementa sobre colecciones programacion funcional
		//imperativa: paso a paso
//		
//		for(String valor:) {
//			imprimir(valor);
//		}

		// UNARY OPERATOR (FUNCTION)

		IPersonaUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat("sufijo");
			return valorFinal;
		};

		LOG.info("UnaryOperator Lambdas:" + unaryLambda.appy("Daniel"));
		// JAVA

	}

}
