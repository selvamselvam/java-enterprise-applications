/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.strategy;

/**
 * AmortizationStrategyJUnit JUnit test  
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.amortization.builder.Amortization;

public class AmortizationStrategyJUnit {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStrategy() {
		Context context = new Context(new AmortizationStrategy());
        List<Amortization> list  =  context.executeStrategy(1000 , 12,12);
        assertNotNull(list);
	}

}
