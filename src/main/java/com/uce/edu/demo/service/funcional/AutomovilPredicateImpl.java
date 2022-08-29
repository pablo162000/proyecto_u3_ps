package com.uce.edu.demo.service.funcional;

public class AutomovilPredicateImpl implements IAutomovilPredicate<String>{

	@Override
	public boolean evaluarSeguro(String arg1) {
		// TODO Auto-generated method stub
		
		
		return arg1.equals("asegurado");
	}

}
