package com.uce.edu.demo.service.funcional;
@FunctionalInterface
public interface IAutomovilFunction <R,T>{
	
	
	public R determinarTipo(T precio);

}
