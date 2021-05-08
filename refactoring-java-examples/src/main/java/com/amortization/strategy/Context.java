/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.strategy;

import java.util.List;

import com.amortization.builder.Amortization;

/**
 * Strategy pattern Context class which uses to set the Strategy 
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class Context {
	 private Strategy strategy;
	 
	    public Context(Strategy strategy) {
	        this.strategy = strategy;
	    }
	    public List<Amortization> executeStrategy(double amount, double apr,int years){
	        return this.strategy.execute(amount, apr,years);
	    }
	    
	   
}
