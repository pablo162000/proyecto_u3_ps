package com.uce.edu.demo.service.funcional;
@FunctionalInterface
public interface IAutomovilPredicate<T> {
	
	
	public boolean evaluarSeguro(T arg1);
	
	

}
