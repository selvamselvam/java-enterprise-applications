/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.util;

/**
 * AmortizationStrategyJUnit JUnit test  
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
import static org.junit.Assert.*;

import org.junit.Test;

import com.amortization.UserPromptsType;
import com.amortization.util.Utility;

public class UtilityJUnit {

	@Test
	public void testValidBorrowAmount() {
		assertEquals("Test with Valid BorrowAmount", true, Utility.isValidBorrowAmount(100));
	}

	@Test
	public void testValidBorrowAmountNegative() {
		assertEquals("Test with negative BorrowAmount", false, Utility.isValidBorrowAmount(-100));
	}
	
	@Test
	public void testValidAPRValue() {
		assertEquals("Test with Valid APR value", true, Utility.isValidAPRValue(100));
	}

	@Test
	public void testValidAPRValueNegative() {
		assertEquals("Test with negative APR value", false, Utility.isValidAPRValue(-100));
	}
	
	
	@Test
	public void testValidTerm() {
		assertEquals("Test with Valid term", true, Utility.isValidTerm(100));
	}

	@Test
	public void testValidTermNegative() {
		assertEquals("Test with negative term", false, Utility.isValidTerm(-100));
	}
	
	@Test
	public void testValidValue() {
		assertEquals("Test with negative term", false, Utility.isValidValue(UserPromptsType.AMOUNT,-100));
	}
	
	
}
