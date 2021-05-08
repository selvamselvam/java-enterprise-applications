package com.amortization.strategy;

import java.util.List;

import com.amortization.builder.Amortization;

public class AmortizationStrategyNew implements Strategy {

	@Override
	public List<Amortization> execute(double amount, double apr, int years) {

		System.out.println("AmortizationStrategyNew");
		
		return null;
	}

}
