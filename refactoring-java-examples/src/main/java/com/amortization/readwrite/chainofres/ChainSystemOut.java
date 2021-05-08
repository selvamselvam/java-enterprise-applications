/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.readwrite.chainofres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Chain of responsibility pattern ChainSystemOut class which implements  Chain 
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class ChainSystemOut implements Chain {
	String line = "";
	
	private Chain nextChain;

	@Override
	public void setNext(Chain nextInChain) {
		setNextChain(nextInChain);
	}

	/**
	 * Method to handle the display request 
	 * @param request request for display
	 * @return void
	 */
	@Override
	public void processDisplay(DisplayRequest request) {
		System.out.print(String.format(request.getStrFormatString(), request.getvArguments()));
		
	}

	/**
	 * Method to handle the read request or move to next handle
	 * @param request read request
	 * @return String read line string 
	 */
	@Override
	public String processRead(ReadRequest request) throws IOException {
		DisplayRequest req = new DisplayRequest("%s",request.getUserPrompt());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
		this.processDisplay(req);
		
		line = bufferedReader.readLine();
		
		line.trim();
		return line;
	}

	/**
	 * @return the nextChain
	 */
	public Chain getNextChain() {
		return nextChain;
	}

	/**
	 * @param nextChain the nextChain to set
	 */
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}
	
	
}
