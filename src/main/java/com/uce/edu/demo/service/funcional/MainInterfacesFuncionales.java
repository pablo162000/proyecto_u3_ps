package com.uce.edu.demo.service.funcional;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		// SUPPLIER

		// Clase
		IAutomovilSupplier<BigDecimal> clsupplier = new AutomovilSupplierImpl();
		LOG.info("Supplier clase:" + clsupplier.getPrecio());
		// IMPLEMENTACION LAMBDA

		IAutomovilSupplier<BigDecimal> supplier = () -> new BigDecimal(30000);
		LOG.info("Supplier Lambda: " + supplier.getPrecio());

		// METODO HIGH ORDER

		BigDecimal precio = metodosHO.consumirAutomovilSupplier(supplier);
		LOG.info("HO Supplier " + precio);

		// CONSUMER

		// Clase
		IAutomovilConsumer<String> clconsumer = new AutomovilConsumerImpl();
		LOG.info("Consumer clase:");
		clconsumer.imprimirMarca("TOYOTA");
		// IMPLEMENTACION LAMBDA

		IAutomovilConsumer<String> consumer = cadena -> System.out.println(cadena);
		LOG.info("Consumer Lambda");

		consumer.imprimirMarca("Consumer Lambda: " + "TOYOTA");
		// METODO HIGH ORDER
		LOG.info("HO Consumer");

		metodosHO.consumirAutomovilConsumer(consumer, "HYUNDAI");

		// PREDICATE
		// Clase
		IAutomovilPredicate<String> clpredicate = new AutomovilPredicateImpl();

		LOG.info("Predicate clase: " + clpredicate.evaluarSeguro("asegurado"));
		// IMPLEMENTACION LAMBDA
		IAutomovilPredicate<String> predicate = cad -> cad.equals("asegurado");

		LOG.info("Predicate Lambda: " + predicate.evaluarSeguro("asegurado"));
		// METODO HIGH ORDER
		LOG.info("HO Predicate");

		LOG.info(metodosHO.consumirAutomovilPredicate(predicate, "asegurado"));

		// FUNCTION

		// Clase

		IAutomovilFunction<String, BigDecimal> clfunction = new AutomovilFunction();
		LOG.info("Function clase: " + clfunction.determinarTipo(precio));

		// IMPLEMENTACION LAMBDA

		IAutomovilFunction<String, BigDecimal> function = p -> {
			String tipo = "";
			if (p.compareTo(new BigDecimal(20000)) > 0) {
				tipo = "Pesado";
			} else {
				tipo = "Liviano";
			}
			return tipo;
		};

		LOG.info("Function Lambda:  " + function.determinarTipo(precio));
		// METODO HIGH ORDER
		LOG.info("HO Function");

		LOG.info(metodosHO.consumirAutomovilFunction(function, precio));

		// UNARYOPERATOR
		// Clase
		IAutomovilUnaryOperator<BigDecimal> clUnaryOperator = new AutomovilUnaryOperator();
		LOG.info("UnaryOperator clase: " + clUnaryOperator.sumarImpuesto(precio));
		// IMPLEMENTACION LAMBDA

		IAutomovilUnaryOperator<BigDecimal> unaryoperator = b -> b.add(b.multiply(new BigDecimal(0.2))).setScale(2,
				RoundingMode.valueOf(0));
		LOG.info("UnaryOperator Lambda: " + unaryoperator.sumarImpuesto(precio));
		// METODO HIGH ORDER
		LOG.info("HO UnaryOperator");
		LOG.info(metodosHO.consumirAutomovilUnaryOperator(unaryoperator, precio));

	}

}
