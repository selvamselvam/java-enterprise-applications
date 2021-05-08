/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.builder;

/**
 * AmortizationJUnit JUnit test  
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AmortizationJUnit {

	Amortization amo = null;
	
	@Before
	public void setUp() throws Exception {
		amo = new Amortization.Builder(5)
		.curMonthlyPaymentAmount(0d)
		.curMonthlyInterest(0d)
		.curBalance(100d)
		.totalPayments(120d)
		.totalInterestPaid(12d)
		.build();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testNotnull() {
		assertNotNull(amo);
	}

	@Test
	public void testValue() {
		assertEquals(amo.getCurBalance(),100d,0d);
	}
	
}
