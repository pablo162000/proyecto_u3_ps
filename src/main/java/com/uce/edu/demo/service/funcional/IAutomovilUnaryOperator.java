package com.uce.edu.demo.service.funcional;
@FunctionalInterface
public interface IAutomovilUnaryOperator<T>{
	
	T sumarImpuesto(T precio);

}
