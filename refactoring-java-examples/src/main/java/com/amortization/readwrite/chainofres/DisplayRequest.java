/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.readwrite.chainofres;

/**
 * Chain of responsibility pattern DisplayRequest class which uses dispaly the request 
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class DisplayRequest {

	private String strFormatString;
	private Object[] vArguments;
	public DisplayRequest(String formatString, Object... args) {
		setStrFormatString(formatString);
		setvArguments(args);
	}
	/**
	 * @return the strFormatString
	 */
	public String getStrFormatString() {
		return strFormatString;
	}
	/**
	 * @param strFormatString the strFormatString to set
	 */
	public void setStrFormatString(String strFormatString) {
		this.strFormatString = strFormatString;
	}
	/**
	 * @return the vArguments
	 */
	public Object[] getvArguments() {
		return vArguments;
	}
	/**
	 * @param vArguments the vArguments to set
	 */
	public void setvArguments(Object[] vArguments) {
		this.vArguments = vArguments;
	}
}
