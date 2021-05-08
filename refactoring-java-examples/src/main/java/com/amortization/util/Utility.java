/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.util;

import java.math.BigDecimal;

import com.amortization.UserPromptsType;
import com.amortization.readwrite.chainofres.Chain;
import com.amortization.readwrite.chainofres.ChainConsole;
import com.amortization.readwrite.chainofres.ChainSystemOut;
import com.amortization.readwrite.chainofres.DisplayRequest;

/**
 * Util methods to validate the arguments  
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class Utility {
	public static final double MONTHLY_INTEREST_DIVISOR = 12d * 100d;
	
	public static final double BORROW_AMOUNT_MIN = 0.01d;
	public static final double BORROW_AMOUNT_MAX = 1000000000000d;
	
	public static final double APR_RANGE_MIN = 0.000001d;
	public static final double APR_RANGE_MAX = 100d;
	
	public static final int TERM_RANGE_MIN = 1;
	public static final int TERM_RANGE_MAX = 1000000;
	

	/**
	 * helper Method to validate the BorrowAmount
	 * @param amount double format
	 * @param boolean return true or false based on the result
	 */
	public static boolean isValidBorrowAmount(double amount) {
		return ((BORROW_AMOUNT_MIN <= amount) && (amount <= BORROW_AMOUNT_MAX));
	}
	
	/**
	 * helper Method to validate the APRValue
	 * @param rate double format
	 * @param boolean return true or false based on the result
	 */
	public static boolean isValidAPRValue(double rate) {
		return ((APR_RANGE_MIN <= rate) && (rate <= APR_RANGE_MAX));
	}
	
	/**
	 * helper Method to validate the ValidTerm
	 * @param rate double format
	 * @param boolean return true or false based on the result
	 */
	public static boolean isValidTerm(int years) {
		return ((TERM_RANGE_MIN <= years) && (years <= TERM_RANGE_MAX));
	}
	
	/**
	 * helper Method to print the string
	 * @param format string format
	 * @param args argument to dispaly
	 */
	public static void PrintString(String format, Object... args){
		Chain h1 = new ChainConsole();
		Chain h2 = new ChainSystemOut();
		h1.setNext(h2);
		DisplayRequest req = new DisplayRequest(format,args);
		h1.processDisplay(req);
	}
	
	public static void PrintString(String strPrint){
		PrintString("%s",strPrint);
	}
	
	/**
	 * helper Method to validate the value
	 * @param type different type of inputs
	 * @param value value to validate
	 * @return the boolean value based on the result
	 */
	public static boolean isValidValue(UserPromptsType type, double val){
		
		if(type == UserPromptsType.AMOUNT && isValidBorrowAmount(val) == false) {
			PrintString("Please enter a positive value between " + (new BigDecimal(BORROW_AMOUNT_MIN).toPlainString().substring(0,4)) + " and " + (new BigDecimal(BORROW_AMOUNT_MAX).toPlainString()) + ". ");
			return false;
		}
		
		if(type == UserPromptsType.ANNUALPER && isValidAPRValue(val) == false) {
			PrintString("Please enter a positive value between " + APR_RANGE_MIN + " and " + APR_RANGE_MAX + ". ");
			return false;
		}
		
		
		if(type == UserPromptsType.AMOUNT && isValidTerm((int)val) == false) {
			PrintString("Please enter a positive value between " + TERM_RANGE_MIN + " and " + TERM_RANGE_MAX + ". ");
			return false;
		}
		
		return true;
	}
	
	
}
