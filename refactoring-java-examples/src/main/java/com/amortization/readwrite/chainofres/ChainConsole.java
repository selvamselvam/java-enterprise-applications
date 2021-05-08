/*
 * 
 * Copyright notice
 * 
 */
package com.amortization.readwrite.chainofres;

import java.io.Console;
import java.io.IOException;

/**
 * Chain of responsibility pattern ChainConsole class which implements  Chain 
 * @version 1.00 27 March 2014
 * @author Selvam Ramasamy
 */
public class ChainConsole implements Chain {

	private static Console console = System.console();
	private String line;
	private Chain nextChain;
	
	/**
	 * Method to set the next chain
	 * @param nextInChain set the next chain
	 * @return void
	 */
	@Override
	public void setNext(Chain nextInChain) {
		nextChain = nextInChain;
		
	}

	/**
	 * Method to handle the display request or move to next handle
	 * @param request request for display
	 * @return void
	 */
	@Override
	public void processDisplay(DisplayRequest request) {
		if (console != null) {
			console.printf(request.getStrFormatString(), request.getvArguments());
		}else{
			nextChain.processDisplay(request);
		}
		
	}

	/**
	 * Method to handle the read request or move to next handle
	 * @param request read request
	 * @return String read line string 
	 */
	@Override
	public String processRead(ReadRequest request) throws IOException {

		if (console != null) {
			
			line = console.readLine(request.getUserPrompt());
		} else{
			line = nextChain.processRead(request);
		}
		line.trim();
		return line;
	}
	

}
