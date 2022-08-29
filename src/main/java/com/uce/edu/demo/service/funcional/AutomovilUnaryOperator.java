package com.uce.edu.demo.service.funcional;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AutomovilUnaryOperator implements IAutomovilUnaryOperator<BigDecimal>{

	@Override
	public BigDecimal sumarImpuesto(BigDecimal b) {
		return  b.add(b.multiply(new BigDecimal(0.2))).setScale(2,
				RoundingMode.valueOf(0));
	}

}
