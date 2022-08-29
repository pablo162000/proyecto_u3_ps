package com.uce.edu.demo.service.funcional;

import java.math.BigDecimal;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IPersonaSupplier<String> funcion) {

		// String valor = funcion.getNombre();
		// Calcular /sumar consultar base, etect
		// Integer numero = Integer.parseInt("valor");
		// return numero;

		return funcion.getNombre() + " Se proceso el dato";
	}

	public BigDecimal consumirAutomovilSupplier(IAutomovilSupplier<BigDecimal> funcion) {

		return funcion.getPrecio();
	}

	public void consumirAutomovilConsumer(IAutomovilConsumer<String> funcion, String marca) {

		funcion.imprimirMarca(marca);
	}

	public boolean consumirAutomovilPredicate(IAutomovilPredicate<String> predicate, String seguro) {

		return predicate.evaluarSeguro(seguro);
		
	}
	
	public String consumirAutomovilFunction(IAutomovilFunction<String, BigDecimal> function, BigDecimal precio) {

		return function.determinarTipo(precio);
		
	}
	
	public BigDecimal consumirAutomovilUnaryOperator(IAutomovilUnaryOperator<BigDecimal> unaryOperator, BigDecimal precio) {

		return unaryOperator.sumarImpuesto(precio);
		
	}
	
	

	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {

		funcion.accept(valor);
	}

	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {

		return funcion.evaluar(valor);
	}

	public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valor) {

		return funcion.aplicar(valor);
	}

}
