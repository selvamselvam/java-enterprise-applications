/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.strategy;

import java.util.List;

import com.amortization.builder.Amortization;

/**
 * Strategy pattern Strategy interface  
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public interface Strategy {
	List<Amortization> execute(double amount, double apr,int years);
}
