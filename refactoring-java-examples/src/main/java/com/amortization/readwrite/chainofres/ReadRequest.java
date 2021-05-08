/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.readwrite.chainofres;

/**
 * Chain of responsibility pattern ReadRequest class which uses read the request 
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class ReadRequest {
	
	private String userPrompt;
	
	public ReadRequest(String userPrompt) {
		setUserPrompt(userPrompt);
		
	}

	/**
	 * @return the userPrompt
	 */
	public String getUserPrompt() {
		return userPrompt;
	}

	/**
	 * @param userPrompt the userPrompt to set
	 */
	public void setUserPrompt(String userPrompt) {
		this.userPrompt = userPrompt;
	}
}
