package com.uce.edu.demo.service.funcional;

import java.math.BigDecimal;

public class AutomovilFunction implements IAutomovilFunction<String, BigDecimal>{

	@Override
	public String determinarTipo(BigDecimal p) {
		// TODO Auto-generated method stub
		String tipo = "";
		if (p.compareTo(new BigDecimal(20000)) > 0) {
			tipo = "Pesado";
		} else {
			tipo = "Liviano";
		}
		return tipo;
	}

}
