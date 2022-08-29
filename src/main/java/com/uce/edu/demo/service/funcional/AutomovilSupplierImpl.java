package com.uce.edu.demo.service.funcional;

import java.math.BigDecimal;

public class AutomovilSupplierImpl implements IAutomovilSupplier<BigDecimal>{

	@Override
	public BigDecimal getPrecio() {
		// TODO Auto-generated method stub
		return new BigDecimal(20000);
	}
	

}
